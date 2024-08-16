package io.github.orlandroyd.auth.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class UserDataValidatorTest {

    private lateinit var validator: UserDataValidator

    @BeforeEach
    fun setUp() {
        validator = UserDataValidator(
            patternValidator = object : PatternValidator {
                override fun matches(value: String): Boolean {
                    return true
                }
            }
        )
    }

    @Test
    fun validatePassword() {
        // GIVEN
        val password = "Test12345"
        // WHEN
        val result = validator.validatePassword(password)
        // THEN
        assertThat(result.isValidPassword).isEqualTo(true)
    }

    @ParameterizedTest
    @CsvSource(
        "Test12345, true",
        "test12345, false",
        "12345, false",
        "Test-12345, true",
        "TEST12345, false",
    )
    fun validateMultiplePassword(password: String, expectedIsValid: Boolean) {
        // WHEN
        val result = validator.validatePassword(password)
        // THEN
        assertThat(result.isValidPassword).isEqualTo(expectedIsValid)
    }
}