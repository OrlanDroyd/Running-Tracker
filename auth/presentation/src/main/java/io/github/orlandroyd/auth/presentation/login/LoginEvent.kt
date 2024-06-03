package io.github.orlandroyd.auth.presentation.login

import io.github.orlandroyd.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}