package Parking_Garage;


public class Car {
    private String licensePlate;  // Make this private for proper encapsulation
    private VehicleType type;

    public Car(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

     public String getLicensePlate() {  // ADD THIS METHOD
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}
