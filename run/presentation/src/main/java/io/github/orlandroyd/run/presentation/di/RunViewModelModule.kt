package io.github.orlandroyd.run.presentation.di

import io.github.orlandroyd.run.presentation.active_run.ActiveRunViewModel
import io.github.orlandroyd.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}