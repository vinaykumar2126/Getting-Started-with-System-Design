/**
 * A simple data class to represent a vehicle.
 * It holds the license plate for identification and the vehicle type for sizing.
 */
package Advanced_parkingLot;
public class Car {
    // --- Fields ---
    private String licensePlate;
    private VehicleType type;

    // --- Constructor ---
    public Car(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    // --- Getters ---
    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}