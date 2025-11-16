package Parking_Lot_System;

import java.util.*;

public class RandomSpotStrategy implements ParkingStrategy {
    @Override
    public int findSpot(PriorityQueue<Integer> availableSpots, Vehicle.VehicleType vehicleType, Map<Integer, ParkingSpot> spotTrack) {
        List<Integer> candidates = new ArrayList<>();
        for (int spotNumber : availableSpots) {
            ParkingSpot spot = spotTrack.get(spotNumber);
            if (!spot.isOccupied() && matchesType(vehicleType, spot.getSpotType())) {
                candidates.add(spotNumber);
            }
        }
        if (candidates.isEmpty()) return -1;
        int idx = new Random().nextInt(candidates.size());
        int chosenSpot = candidates.get(idx);
        availableSpots.remove(chosenSpot); // Remove from available
        return chosenSpot;
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