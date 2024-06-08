package io.github.orlandroyd.run.presentation.active_run

import io.github.orlandroyd.core.presentation.ui.UiText


sealed interface ActiveRunEvent {
    data class Error(val error: UiText) : ActiveRunEvent
    data object RunSaved : ActiveRunEvent
}