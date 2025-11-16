package WithStrategyPattern;

public class Main {
    public static void Main(String args[]) {
        Vehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive(); // Output: Sports drive capability

        // Vehicle vehicle = new Vehicle(new SportsDriveStrategy());  // Inject strategy
        // vehicle.drive();

        Vehicle offRoadVehicle = new OffRoadVehicle();
        offRoadVehicle.drive(); // Output: Sports drive capability

        Vehicle goodsVehicle = new GoodsVehicle();
        goodsVehicle.drive(); // Output: Normal drive capability

        Vehicle cyclevehicle = new CycleVehicle();
        cyclevehicle.drive(); // Output: Sports drive capability with flying
    }
    
}