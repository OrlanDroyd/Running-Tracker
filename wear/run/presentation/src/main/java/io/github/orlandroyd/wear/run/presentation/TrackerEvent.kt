package io.github.orlandroyd.wear.run.presentation

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
}