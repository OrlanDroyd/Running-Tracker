package io.github.orlandroyd.run.presentation.di

import io.github.orlandroyd.run.domain.RunningTracker
import io.github.orlandroyd.run.presentation.active_run.ActiveRunViewModel
import io.github.orlandroyd.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}