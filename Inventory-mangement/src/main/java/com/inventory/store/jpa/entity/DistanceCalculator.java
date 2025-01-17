package com.inventory.store.jpa.entity;

public class DistanceCalculator {
	   private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
	   public static double calculateDistance(double startLat, double startLong, double endLat, double endLong) {
	       double dLat = Math.toRadians(endLat - startLat);
	       double dLong = Math.toRadians(endLong - startLong);
	       double startLatRad = Math.toRadians(startLat);
	       double endLatRad = Math.toRadians(endLat);
	       double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	                  Math.sin(dLong / 2) * Math.sin(dLong / 2) *
	                  Math.cos(startLatRad) * Math.cos(endLatRad);
	       double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	       return EARTH_RADIUS * c; // returns the distance in kilometers
	   }
	}
