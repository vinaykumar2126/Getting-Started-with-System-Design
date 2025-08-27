package Parking_Garage;
import java.util.*;

public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private VehicleType allowedType;
    private Car parkedCar;

    public ParkingSpot(int spotNumber, VehicleType allowedType) {
        this.spotNumber = spotNumber;
        this.allowedType = allowedType;
        this.isOccupied = false;
        this.parkedCar = null;
    }

    public boolean canFitCar(Car car) {
        return !isOccupied && car.getType().ordinal() <= allowedType.ordinal();
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void parkCar(Car car) {
        this.parkedCar = car;
        this.isOccupied = true;
    }

    public void removeCar() {
        this.parkedCar = null;
        this.isOccupied = false;
    }
}
