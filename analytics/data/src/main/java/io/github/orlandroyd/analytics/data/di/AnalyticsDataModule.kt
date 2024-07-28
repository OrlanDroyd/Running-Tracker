package io.github.orlandroyd.analytics.data.di

import io.github.orlandroyd.analytics.data.RoomAnalyticsRepository
import io.github.orlandroyd.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind()
    single {
        get<RunDatabase>().analyticsDao
    }
}