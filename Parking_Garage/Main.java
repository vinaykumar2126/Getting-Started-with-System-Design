package Parking_Garage;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a garage with 5 spots
        ParkingGarage garage = new ParkingGarage(5);

        // Park some cars
        Car car1 = new Car("ABC123", VehicleType.SMALL);
        Car car2 = new Car("XYZ789", VehicleType.LARGE);

        int spot1 = garage.park(car1);
        System.out.println("Car:" + car1.getLicensePlate() + " parked at spot " + spot1);

        int spot2 = garage.park(car2);
        System.out.println("Car " + car2.getLicensePlate() + " parked at spot " + spot2);

        // Try unparking car1
        boolean success = garage.unpark("ABC123");
        System.out.println("Unpark ABC123: " + success);

        // Park another car after freeing a spot
        Car car3 = new Car("LMN456", VehicleType.MEDIUM);
        int spot3 = garage.park(car3);
        System.out.println("Car " + car3.getLicensePlate() + " parked at spot " + spot3);
    }
}
