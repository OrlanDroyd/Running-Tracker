package io.github.orlandroyd.wear.run.data.di

import io.github.orlandroyd.wear.run.data.HealthServicesExerciseTracker
import io.github.orlandroyd.wear.run.domain.ExerciseTracker
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val wearRunDataModule = module {
    singleOf(::HealthServicesExerciseTracker).bind<ExerciseTracker>()
}