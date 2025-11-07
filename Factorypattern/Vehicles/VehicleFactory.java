package Vehicles;
// Can't delcare static inside a method because it belongs to the class, not to instances or methods
//If we declare it inside then in every method call a new variable will be created which is not the purpose of static, Contradiction!
//So static is always created once and shared across all method calls, hence it should be declared at class level
public class VehicleFactory {
    private static final Vehicle Car = new Car();
    private static final Vehicle Bike = new Bike();
    private static final Vehicle Truck = new Truck();
    public static Vehicle createVehicle(String type){
        if(type.equalsIgnoreCase("CAR")){
            return Car;
        } else if(type.equalsIgnoreCase("BIKE")){
            return Bike;
        } else if(type.equalsIgnoreCase("TRUCK")){
            return Truck;
        }
        return null;
    }

    
}

