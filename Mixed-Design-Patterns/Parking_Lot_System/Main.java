package Parking_Lot_System;

public class Main {
    public static void main(String args[]){
        Vehicle bike = new Vehicle("BIKE123", Vehicle.VehicleType.BIKE);
        Vehicle CAR = new Vehicle("CAR456", Vehicle.VehicleType.CAR);
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.setStrategy(new NearestSpotStrategy());
        int spot1 = parkingLot.findSpotAndParkVehicle(bike);
        System.out.println("Vehicle parked at spot: " + spot1);
        // boolean success = parkingLot.checkoutVehicle(bike);
        int carSpot = parkingLot.findSpotAndParkVehicle(CAR);
        System.out.println("Vehicle parked at spot: " + carSpot);
        // System.out.println("Vehicle checkout successful: " + success);

    }

    }

