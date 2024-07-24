package io.github.orlandroyd.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}