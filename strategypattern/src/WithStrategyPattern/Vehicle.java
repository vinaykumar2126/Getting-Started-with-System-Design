package WithStrategyPattern;
import WithStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveObject;

    //Constructor Injection
    Vehicle(DriveStrategy driveObject) {
        this.driveObject = driveObject;
    }
    public void drive() {
        driveObject.drive();
    }

}

