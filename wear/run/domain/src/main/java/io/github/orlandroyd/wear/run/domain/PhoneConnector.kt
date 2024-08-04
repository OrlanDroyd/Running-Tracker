package io.github.orlandroyd.wear.run.domain

import io.github.orlandroyd.core.connectivity.domain.DeviceNode
import kotlinx.coroutines.flow.StateFlow

interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>
}