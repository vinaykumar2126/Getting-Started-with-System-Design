package Parking_Garage;
import java.util.*;

public class ParkingGarage {
    Map<Integer, ParkingSpot> spots;
    PriorityQueue<Integer> available;
    Map<String, Integer> licenseToSpot;

    public ParkingGarage(int totalSpots) {
        spots = new HashMap<>();
        available = new PriorityQueue<>();
        licenseToSpot = new HashMap<>();

        for (int i = 1; i <= totalSpots; i++) {//Creating parking spots
            spots.put(i, new ParkingSpot(i, VehicleType.LARGE)); //Mapping spot number to ParkingSpot object
            available.offer(i); //Adding spot number to available spots queue
        }
    }

    public int park(Car car) {
        while (!available.isEmpty()) {
            int spotNumber = available.poll();
            ParkingSpot spot = spots.get(spotNumber);  //Retrieving the ParkingSpot object for the spot number

            if (spot.canFitCar(car)) {
                spot.parkCar(car);   // modyfyinfg the current state of the spot
                licenseToSpot.put(car.getLicensePlate(), spotNumber);
                return spotNumber;
            }
        }
        return -1; // no spot available
    }

    public boolean unpark(String licensePlate) {
        if (!licenseToSpot.containsKey(licensePlate)) return false;

        int spotNumber = licenseToSpot.remove(licensePlate);
        ParkingSpot spot = spots.get(spotNumber);

        spot.removeCar();
        available.offer(spotNumber);
        return true;
    }
}