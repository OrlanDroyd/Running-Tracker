package io.github.orlandroyd.core.connectivity.data

import com.google.android.gms.wearable.Node
import io.github.orlandroyd.core.connectivity.domain.DeviceNode

fun Node.toDeviceNode(): DeviceNode {
    return DeviceNode(
        id = id,
        displayName = displayName,
        isNearby = isNearby
    )
}