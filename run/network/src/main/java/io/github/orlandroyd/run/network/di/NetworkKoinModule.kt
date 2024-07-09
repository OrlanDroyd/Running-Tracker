package io.github.orlandroyd.run.network.di

import io.github.orlandroyd.core.domain.run.RemoteRunDataSource
import io.github.orlandroyd.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}