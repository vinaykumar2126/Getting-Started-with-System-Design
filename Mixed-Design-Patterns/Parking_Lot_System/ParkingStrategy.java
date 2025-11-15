package Parking_Lot_System;
import java.util.*;
public interface ParkingStrategy {
    public int findSpot(PriorityQueue<Integer> availableSpots,Vehicle.VehicleType vehicleType, Map<Integer, ParkingSpot> spotTrack);
}
