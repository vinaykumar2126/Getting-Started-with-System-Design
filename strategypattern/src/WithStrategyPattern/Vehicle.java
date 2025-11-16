package WithStrategyPattern;
import WithStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveObject; // Has-a relationship with DriveStrategy

    //Constructor Injection
    Vehicle(DriveStrategy driveObject) {
        this.driveObject = driveObject;  //pluggable behavior
    }
    public void drive() {
        driveObject.drive();
    }

}




