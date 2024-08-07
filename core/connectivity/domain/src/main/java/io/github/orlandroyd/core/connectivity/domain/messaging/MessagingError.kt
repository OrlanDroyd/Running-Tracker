package io.github.orlandroyd.core.connectivity.domain.messaging

import io.github.orlandroyd.core.domain.util.Error

enum class MessagingError : Error {
    CONNECTION_INTERRUPTED,
    DISCONNECTED,
    UNKNOWN
}