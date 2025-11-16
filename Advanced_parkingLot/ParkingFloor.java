import java.util.ArrayList;
import java.util.List;
package Advanced_parkingLot;
/**
 * Represents a single floor in the parking garage.
 * It is responsible for managing all the spots on its level.
 */
public class ParkingFloor {
    // --- Fields ---
    private int floorNumber;
    private List<ParkingSpot> spots;

    // --- Constructor ---
    public ParkingFloor(int floorNumber, int numberOfSpots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        // Create the spots for this floor upon construction.
        for (int i = 1; i <= numberOfSpots; i++) {
            // This could be enhanced to create different spot types per floor.
            spots.add(new ParkingSpot(i, VehicleType.LARGE));
        }
    }

    // --- Public Methods ---
    /**
     * Iterates through its spots to find a suitable one and parks the car.
     * @param car The car to park.
     * @return The ParkingSpot object if successful, otherwise null.
     */
    public ParkingSpot findAndPark(Car car) {
        for (ParkingSpot spot : spots) {
            if (spot.canFitCar(car)) {
                spot.parkCar(car);
                System.out.println("Car parked on Floor " + this.floorNumber + ", Spot " + spot.getSpotNumber());
                return spot;
            }
        }
        return null; // No available spot found on this floor.
    }
}

