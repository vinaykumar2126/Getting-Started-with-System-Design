package Vehicles;

public class VehicleFactory {
    public static Vehicle createVehicle(String type){
        if(type.equalsIgnoreCase("CAR")){
            return new Car();
        } else if(type.equalsIgnoreCase("BIKE")){
            return new Bike();
        } else if(type.equalsIgnoreCase("TRUCK")){
            return new Truck();
        }
        return null;
    }

    
}
