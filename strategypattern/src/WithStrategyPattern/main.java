package WithStrategyPattern;

public class main {
    public static void main(String args[]) {
        Vehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive(); // Output: Sports drive capability

        Vehicle offRoadVehicle = new OffRoadVehicle();
        offRoadVehicle.drive(); // Output: Sports drive capability

        Vehicle goodsVehicle = new GoodsVehicle();
        goodsVehicle.drive(); // Output: Normal drive capability
    }
    
}
