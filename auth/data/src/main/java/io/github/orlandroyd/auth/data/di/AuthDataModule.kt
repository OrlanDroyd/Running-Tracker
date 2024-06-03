package io.github.orlandroyd.auth.data.di

import io.github.orlandroyd.auth.data.AuthRepositoryImpl
import io.github.orlandroyd.auth.data.EmailPatternValidator
import io.github.orlandroyd.auth.domain.AuthRepository
import io.github.orlandroyd.auth.domain.PatternValidator
import io.github.orlandroyd.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}