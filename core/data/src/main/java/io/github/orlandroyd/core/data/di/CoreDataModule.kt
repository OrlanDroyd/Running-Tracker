package io.github.orlandroyd.core.data.di

import io.github.orlandroyd.core.data.auth.EncryptedSessionStorage
import io.github.orlandroyd.core.data.networking.HttpClientFactory
import io.github.orlandroyd.core.data.run.OfflineFirstRunRepository
import io.github.orlandroyd.core.domain.SessionStorage
import io.github.orlandroyd.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}