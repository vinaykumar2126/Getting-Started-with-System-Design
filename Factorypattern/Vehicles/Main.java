package Vehicles;

public class Main {
    public static void main(String args[]){
        Vehicle car = VehicleFactory.createVehicle("CAR");
        car.start();
        car.getType();
        Vehicle bike = VehicleFactory.createVehicle("BIKE");
        bike.start();
        bike.getType();
        Vehicle truck = VehicleFactory.createVehicle("TRUCK");
        truck.start();
        truck.getType();

    }
    
}
