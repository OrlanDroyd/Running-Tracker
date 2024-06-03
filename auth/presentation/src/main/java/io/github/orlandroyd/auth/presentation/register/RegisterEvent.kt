package io.github.orlandroyd.auth.presentation.register

import io.github.orlandroyd.core.presentation.ui.UiText

sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class Error(val error: UiText) : RegisterEvent
}