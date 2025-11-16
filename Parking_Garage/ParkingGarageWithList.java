// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// public class ParkingGarageWithList {
//     private Map<Integer, ParkingSpot> spots; // Stores the actual ParkingSpot objects
//     private List<Integer> availableSpots;    // A list of numbers for empty spots
//     private Map<String, Integer> licenseToSpot; // Links a car to a spot number

//     public ParkingGarageWithList(int totalSpots) {
//         this.spots = new HashMap<>();
//         this.availableSpots = new ArrayList<>();
//         this.licenseToSpot = new HashMap<>();

//         for (int i = 1; i <= totalSpots; i++) {
//             spots.put(i, new ParkingSpot(i, VehicleType.LARGE));
//             availableSpots.add(i); // Add each spot number to the available list
//         }
//     }

//     public int park(Car car) {
//         if (availableSpots.isEmpty()) {
//             System.out.println("Sorry, the garage is full.");
//             return -1; // No spots available
//         }

//         // Get the first available spot from the beginning of the list
//         int spotNumber = availableSpots.remove(0);
//         ParkingSpot spot = spots.get(spotNumber);

//         if (spot.canFitCar(car)) {
//             spot.parkCar(car);
//             licenseToSpot.put(car.getLicensePlate(), spotNumber);
//             System.out.println("Car " + car.getLicensePlate() + " parked in spot " + spotNumber);
//             return spotNumber;
//         }
        
//         // If the car can't fit, we should add the spot back.
//         availableSpots.add(spotNumber);
//         return -1;
//     }

//     public boolean unpark(String licensePlate) {
//         if (!licenseToSpot.containsKey(licensePlate)) {
//             System.out.println("Car with license plate " + licensePlate + " not found.");
//             return false;
//         }

//         int spotNumber = licenseToSpot.remove(licensePlate);
//         ParkingSpot spot = spots.get(spotNumber);

//         spot.removeCar();
//         // Add the newly empty spot number back to the list of available spots
//         availableSpots.add(spotNumber);
//         System.out.println("Spot " + spotNumber + " is now free.");
//         return true;
//     }
// }


// package Parking_Garage;
// import java.util.*;

// public class ParkingGarage {
//     Map<Integer, ParkingSpot> spots;
//     PriorityQueue<Integer> available;
//     Map<String, Integer> licenseToSpot;

//     public ParkingGarage(int totalSpots) {
//         spots = new HashMap<>();
//         available = new PriorityQueue<>();
//         licenseToSpot = new HashMap<>();

//         for (int i = 1; i <= totalSpots; i++) {
//             spots.put(i, new ParkingSpot(i, VehicleType.LARGE)); 
//             available.offer(i);
//         }
//     }

//     public int park(Car car) {
//         if (available.isEmpty()) {
//             return -1; // No spot available
//         }

//         int spotNumber = available.poll();
//         ParkingSpot spot = spots.get(spotNumber);

//         if (spot.canFitCar(car)) {
//             spot.parkCar(car);
//             licenseToSpot.put(car.getLicensePlate(), spotNumber);
//             return spotNumber;
//         }
        
//         // This part is problematic in the original logic, as a spot that can't fit the car
//         // is removed from `available` but not put back. A more robust solution would
//         // iterate or handle this case differently. For this simple logic, we assume
//         // the first available spot can fit the car.
//         return -1; // Should handle the case where the spot can't fit the car.
//     }

//     public boolean unpark(String licensePlate) {
//         if (!licenseToSpot.containsKey(licensePlate)) {
//             return false;
//         }

//         int spotNumber = licenseToSpot.remove(licensePlate);
//         ParkingSpot spot = spots.get(spotNumber);

//         spot.removeCar();
//         available.offer(spotNumber);
//         return true;
//     }
// }


//  public int park(Car car) {
//         while (!available.isEmpty()) {
//             int spotNumber = available.poll();
//             ParkingSpot spot = spots.get(spotNumber);

//             // Inline logic instead of helper functions
//             if (!spot.isOccupied && car.type.ordinal() <= spot.allowedType.ordinal()) {
//                 spot.parkedCar = car;
//                 spot.isOccupied = true;
//                 licenseToSpot.put(car.licensePlate, spotNumber);
//                 return spotNumber;
//             }
//         }
//         return -1; // no spot available
//     }


//    public boolean unpark(String licensePlate) {
//         if (!licenseToSpot.containsKey(licensePlate)) return false;

//         int spotNumber = licenseToSpot.remove(licensePlate);
//         ParkingSpot spot = spots.get(spotNumber);

//         // Inline logic instead of helper functions
//         spot.parkedCar = null;
//         spot.isOccupied = false;
//         available.offer(spotNumber);
//         return true;
//     }