package io.github.orlandroyd.analytics.data.di

import io.github.orlandroyd.analytics.data.RoomAnalyticsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind()
}