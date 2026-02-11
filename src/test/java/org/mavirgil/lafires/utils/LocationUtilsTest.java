package org.mavirgil.lafires.utils;

import org.junit.jupiter.api.Test;
import org.mavirgil.lafires.model.Location;

import static org.junit.jupiter.api.Assertions.*;
import static org.mavirgil.lafires.utils.LocationUtils.calculateDistanceKm;

class LocationUtilsTest {

    @Test
    void shouldCalculateShortDistance() {
        final double EXPECTED_DISTANCE_KM = 1.06;

        Location location1 = new Location(34.01393966755222, -118.30524076683382);
        Location location2 = new Location(34.004797019072015, -118.30210794679243);
        double distance = calculateDistanceKm(location1, location2);

        assertEquals(EXPECTED_DISTANCE_KM, distance);
    }

    @Test
    void shouldCalculateLongDistance() {
        final double EXPECTED_DISTANCE_KM = 23.04;

        Location location1 = new Location(34.021349204256936, -118.32854005040817);
        Location location2 = new Location(33.89570047451018, -118.12995759279495);
        double distance = calculateDistanceKm(location1, location2);

        assertEquals(EXPECTED_DISTANCE_KM, distance);
    }
}