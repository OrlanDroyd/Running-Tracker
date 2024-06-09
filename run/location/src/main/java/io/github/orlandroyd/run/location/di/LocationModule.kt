package io.github.orlandroyd.run.location.di

import io.github.orlandroyd.run.domain.LocationObserver
import io.github.orlandroyd.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}