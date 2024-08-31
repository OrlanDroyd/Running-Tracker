package io.github.orlandroyd.core.android_test

import io.github.orlandroyd.core.domain.AuthInfo
import io.github.orlandroyd.core.domain.SessionStorage

class SessionStorageFake : SessionStorage {

    private var authInfo: AuthInfo? = null

    override suspend fun get(): AuthInfo? {
        return authInfo
    }

    override suspend fun set(info: AuthInfo?) {
        authInfo = info
    }
}