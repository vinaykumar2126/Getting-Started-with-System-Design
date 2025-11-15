package Parking_Lot_System;

public class Vehicle {
    public enum VehicleType{
    CAR,
    BIKE,
    TRUCK
}
    private String vehicleNumber;
    private VehicleType vehicletype;

    public Vehicle(String vehicleNumber,VehicleType vehicletype){
        this.vehicletype = vehicletype;
        this.vehicleNumber = vehicleNumber;
    }
    public VehicleType getVehicleType(){
        return vehicletype;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    
}
