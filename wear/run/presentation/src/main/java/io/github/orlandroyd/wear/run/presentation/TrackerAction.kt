package io.github.orlandroyd.wear.run.presentation

sealed interface TrackerAction {
    data object OnToggleRunClick: TrackerAction
    data object OnFinishRunClick: TrackerAction
    data class OnBodySensorPermissionResult(val isGranted: Boolean): TrackerAction
}