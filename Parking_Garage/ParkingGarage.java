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

        for (int i = 1; i <= totalSpots; i++) {
            spots.put(i, new ParkingSpot(i, VehicleType.LARGE)); 
            available.offer(i);
        }
    }

    public int park(Car car) {
        while (!available.isEmpty()) {
            int spotNumber = available.poll();
            ParkingSpot spot = spots.get(spotNumber);

            if (spot.canFitCar(car)) {
                spot.parkCar(car);
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