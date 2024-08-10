package io.github.orlandroyd.wear.run.presentation

import io.github.orlandroyd.core.presentation.ui.UiText

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
    data class Error(val message: UiText): TrackerEvent
}