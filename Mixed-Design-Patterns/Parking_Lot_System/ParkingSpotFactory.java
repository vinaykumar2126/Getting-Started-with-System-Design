package Parking_Lot_System;

public class ParkingSpotFactory {
    public static ParkingSpot createSpot(ParkingSpot.SpotType type,int spotNumber){
        return new ParkingSpot(type,spotNumber);
    }
}
