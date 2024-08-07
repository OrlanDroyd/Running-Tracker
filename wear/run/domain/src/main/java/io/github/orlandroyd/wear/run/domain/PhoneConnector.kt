package io.github.orlandroyd.wear.run.domain

import io.github.orlandroyd.core.connectivity.domain.DeviceNode
import io.github.orlandroyd.core.connectivity.domain.messaging.MessagingAction
import io.github.orlandroyd.core.connectivity.domain.messaging.MessagingError
import io.github.orlandroyd.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>
    val messagingActions: Flow<MessagingAction>
    suspend fun sendActionToPhone(action: MessagingAction): EmptyResult<MessagingError>
}