@file:OptIn(ExperimentalFoundationApi::class)

package io.github.orlandroyd.auth.presentation.login

import androidx.compose.foundation.ExperimentalFoundationApi
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isNotNull
import assertk.assertions.isTrue
import io.github.orlandroyd.auth.data.AuthRepositoryImpl
import io.github.orlandroyd.auth.data.EmailPatternValidator
import io.github.orlandroyd.auth.data.LoginRequest
import io.github.orlandroyd.auth.domain.UserDataValidator
import io.github.orlandroyd.core.android_test.SessionStorageFake
import io.github.orlandroyd.core.android_test.TestMockEngine
import io.github.orlandroyd.core.android_test.loginResponseStub
import io.github.orlandroyd.core.data.networking.HttpClientFactory
import io.github.orlandroyd.core.test.MainCoroutineExtension
import io.ktor.client.engine.mock.MockEngineConfig
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.toByteArray
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class LoginViewModelTest {

    companion object {
        @JvmField
        @RegisterExtension
        val mainCoroutineExtension = MainCoroutineExtension()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var repository: AuthRepositoryImpl
    private lateinit var sessionStorageFake: SessionStorageFake
    private lateinit var mockEngine: TestMockEngine

    private val mockEmail = "test@test.com"
    private val mockPassword = "Test12345"

    @BeforeEach
    fun setUp() {
        sessionStorageFake = SessionStorageFake()

        val mockEngineConfig = MockEngineConfig().apply {
            requestHandlers.add { request ->
                val relativeUrl = request.url.encodedPath
                if (relativeUrl == "/login") {
                    respond(
                        content = ByteReadChannel(
                            text = Json.encodeToString(loginResponseStub)
                        ),
                        headers = headers {
                            set("Content-Type", "application/json")
                        }
                    )
                } else {
                    respond(
                        content = byteArrayOf(),
                        status = HttpStatusCode.InternalServerError
                    )
                }
            }
        }
        mockEngine = TestMockEngine(
            dispatcher = mainCoroutineExtension.testDispatcher,
            mockEngineConfig = mockEngineConfig
        )

        val httpClient = HttpClientFactory(
            sessionStorage = sessionStorageFake
        ).build(mockEngine)
        repository = AuthRepositoryImpl(
            httpClient = httpClient,
            sessionStorage = sessionStorageFake
        )

        viewModel = LoginViewModel(
            authRepository = repository,
            userDataValidator = UserDataValidator(
                patternValidator = EmailPatternValidator
            )
        )
    }

    @Test
    fun testLogin() = runTest {
        assertThat(viewModel.state.canLogin).isFalse()

        viewModel.state.email.edit {
            append(mockEmail)
        }
        viewModel.state.password.edit {
            append(mockPassword)
        }

        viewModel.onAction(LoginAction.OnLoginClick)

        assertThat(viewModel.state.isLoggingIn).isFalse()
        assertThat(viewModel.state.email.text.toString()).isEqualTo(mockEmail)
        assertThat(viewModel.state.password.text.toString()).isEqualTo(mockPassword)

        val loginRequest = mockEngine.mockEngine.requestHistory.find {
            it.url.encodedPath == "/login"
        }
        assertThat(loginRequest).isNotNull()
        assertThat(loginRequest!!.headers.contains("x-api-key")).isTrue()

        val loginBody = Json.decodeFromString<LoginRequest>(
            loginRequest.body.toByteArray().decodeToString()
        )
        assertThat(loginBody.email).isEqualTo(mockEmail)
        assertThat(loginBody.password).isEqualTo(mockPassword)

        val session = sessionStorageFake.get()
        assertThat(session?.userId).isEqualTo(loginResponseStub.userId)
        assertThat(session?.accessToken).isEqualTo(loginResponseStub.accessToken)
        assertThat(session?.refreshToken).isEqualTo(loginResponseStub.refreshToken)
    }
}