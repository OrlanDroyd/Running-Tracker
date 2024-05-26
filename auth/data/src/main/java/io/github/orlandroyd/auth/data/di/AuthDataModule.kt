package io.github.orlandroyd.auth.data.di

import io.github.orlandroyd.auth.data.EmailPatternValidator
import io.github.orlandroyd.auth.domain.PatternValidator
import io.github.orlandroyd.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}