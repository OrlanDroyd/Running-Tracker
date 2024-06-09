package io.github.orlandroyd.run.location

import android.location.Location
import io.github.orlandroyd.core.domain.location.LocationWithAltitude

typealias LocationDomain = io.github.orlandroyd.core.domain.location.Location

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = LocationDomain(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}