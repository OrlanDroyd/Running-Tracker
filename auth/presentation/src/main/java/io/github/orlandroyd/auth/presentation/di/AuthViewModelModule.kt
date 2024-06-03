package io.github.orlandroyd.auth.presentation.di

import io.github.orlandroyd.auth.presentation.login.LoginViewModel
import io.github.orlandroyd.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}