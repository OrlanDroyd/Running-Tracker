package io.github.orlandroyd.auth.data

import io.github.orlandroyd.auth.domain.AuthRepository
import io.github.orlandroyd.core.data.networking.post
import io.github.orlandroyd.core.domain.AuthInfo
import io.github.orlandroyd.core.domain.SessionStorage
import io.github.orlandroyd.core.domain.util.DataError
import io.github.orlandroyd.core.domain.util.EmptyResult
import io.github.orlandroyd.core.domain.util.Result
import io.github.orlandroyd.core.domain.util.asEmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyResult()
    }

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}