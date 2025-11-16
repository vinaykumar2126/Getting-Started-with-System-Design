package Parking_Lot_System;

import java.util.*;

public class NearestSpotStrategy implements ParkingStrategy {
    @Override
    public int findSpot(PriorityQueue<Integer> availableSpots, Vehicle.VehicleType vehicleType, Map<Integer, ParkingSpot> spotTrack) {
        for (int spotNumber : availableSpots) {
            ParkingSpot spot = spotTrack.get(spotNumber);
            if (!spot.isOccupied() && matchesType(vehicleType, spot.getSpotType())) {
                availableSpots.remove(spotNumber); // Remove from available
                return spotNumber;
            }
        }
        return -1; // No matching spot found
    }

    private boolean matchesType(Vehicle.VehicleType vehicleType, ParkingSpot.SpotType spotType) {
        switch (vehicleType) {
            case BIKE: return spotType == ParkingSpot.SpotType.SMALL || spotType == ParkingSpot.SpotType.REGULAR;
            case CAR: return spotType == ParkingSpot.SpotType.REGULAR || spotType == ParkingSpot.SpotType.LARGE;
            case TRUCK: return spotType == ParkingSpot.SpotType.LARGE;
            default: return false;
        }
    }
}