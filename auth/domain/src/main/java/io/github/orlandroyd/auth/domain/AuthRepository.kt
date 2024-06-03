package io.github.orlandroyd.auth.domain

import io.github.orlandroyd.core.domain.util.DataError
import io.github.orlandroyd.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}