package org.mavirgil.lafires.utils;

import org.mavirgil.lafires.model.Location;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class LocationUtils {

    private final double NAUTICAL_MILES_IN_DEGREE = 60;
    private final double KILOMETERS_IN_NAUTICAL_MILE = 1.852;

    public static double calculateDistanceKm(Location loc1, Location loc2) {
        //uses the haversine formula
        final double EARTH_RADIUS_KM = 6371;

        //get latitude & longitude in radians
        double deltaLat = Math.toRadians((loc2.getLatitude()) - loc1.getLatitude());
        double deltaLong = Math.toRadians((loc2.getLongitude() - loc1.getLongitude()));

        double startLatRadian = Math.toRadians(loc1.getLatitude());
        double endLatRadian = Math.toRadians(loc2.getLatitude());

        double a = haversine(deltaLat) + Math.cos(startLatRadian) * Math.cos(endLatRadian) * haversine(deltaLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        //distance between to points in km
        double result = c * EARTH_RADIUS_KM;

        //round result to two decimal places
        return new BigDecimal(String.valueOf(result)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private static double haversine(double value) {
        return Math.pow(Math.sin(value / 2), 2);
    }
}
