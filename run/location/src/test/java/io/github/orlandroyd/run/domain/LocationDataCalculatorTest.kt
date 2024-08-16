package io.github.orlandroyd.run.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.github.orlandroyd.core.domain.location.Location
import io.github.orlandroyd.core.domain.location.LocationTimestamp
import io.github.orlandroyd.core.domain.location.LocationWithAltitude
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.time.Duration.Companion.seconds

class LocationDataCalculatorTest {

    private lateinit var locationDataCalculator: LocationDataCalculator

    @BeforeEach
    fun setUp() {
        locationDataCalculator = LocationDataCalculator
    }

    @Test
    fun getMaxSpeedKmh() {
        val locations = listOf(
            listOf(
                LocationTimestamp(
                    location = LocationWithAltitude(
                        location = Location(
                            lat = 1.0,
                            long = 1.0
                        ), altitude = 10.11
                    ), durationTimestamp = 10.seconds
                ),
                LocationTimestamp(
                    location = LocationWithAltitude(
                        location = Location(
                            lat = 2.0,
                            long = 1.0
                        ), altitude = 10.11
                    ), durationTimestamp = 20.seconds
                ),
                LocationTimestamp(
                    location = LocationWithAltitude(
                        location = Location(
                            lat = 4.0,
                            long = 1.0
                        ), altitude = 10.11
                    ), durationTimestamp = 20.seconds
                )
            )
        )

        val result = locationDataCalculator.getMaxSpeedKmh(locations)

        assertThat(result).isEqualTo(40030.174687499995)
    }


}