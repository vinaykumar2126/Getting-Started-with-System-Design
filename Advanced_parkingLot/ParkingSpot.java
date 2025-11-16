/**
 * Represents a single parking spot in the garage.
 * It knows its size, its number, and whether it is currently occupied.
 */
package Advanced_parkingLot;
public class ParkingSpot {
    // --- Fields ---
    private int spotNumber;
    private VehicleType allowedType; // The largest vehicle size this spot can hold.
    private boolean isOccupied;
    private Car parkedCar;

    // --- Constructor ---
    /**
     * Creates a new ParkingSpot. It is always initialized as empty.
     * @param spotNumber The unique number for this spot.
     * @param allowedType The size of the spot.
     */
    public ParkingSpot(int spotNumber, VehicleType allowedType) {
        this.spotNumber = spotNumber;
        this.allowedType = allowedType;
        this.isOccupied = false; // A new spot is always empty.
        this.parkedCar = null;   // A new spot has no car.
    }

    // --- Public Methods ---
    /**
     * Checks if a car can fit in this spot.
     * The spot must be empty and large enough for the car.
     * We use ordinal() to compare enum sizes (SMALL=0, MEDIUM=1, LARGE=2).
     */
    public boolean canFitCar(Car car) {
        return !isOccupied && car.getType().ordinal() <= this.allowedType.ordinal();
    }

    /**
     * Parks a car in this spot, updating its state to occupied.
     */
    public void parkCar(Car car) {
        this.parkedCar = car;
        this.isOccupied = true;
    }

    /**
     * Removes a car from this spot, updating its state to empty.
     */
    public void removeCar() {
        this.parkedCar = null;
        this.isOccupied = false;
    }
    
    // --- Getters (for safe, read-only access to private data) ---
    public boolean isOccupied() {
        return isOccupied;
    }

    public Car getParkedCar() {
        return parkedCar;
    }
    
    public int getSpotNumber() {
        return spotNumber;
    }
}