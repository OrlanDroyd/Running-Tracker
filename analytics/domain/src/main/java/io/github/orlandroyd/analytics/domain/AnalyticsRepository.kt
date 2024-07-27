package io.github.orlandroyd.analytics.domain

interface AnalyticsRepository {
    suspend fun getAnalyticsValues(): AnalyticsValues
}