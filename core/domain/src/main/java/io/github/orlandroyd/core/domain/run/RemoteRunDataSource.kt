package io.github.orlandroyd.core.domain.run

import io.github.orlandroyd.core.domain.util.DataError
import io.github.orlandroyd.core.domain.util.EmptyResult
import io.github.orlandroyd.core.domain.util.Result

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>
    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>
    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}