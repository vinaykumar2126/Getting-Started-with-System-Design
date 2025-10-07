package Vehicles;

public class Truck implements Vehicle{
    @Override
    public void start(){
        System.out.println("Truck started");
    }   
    @Override
    public void stop(){
        System.out.println("Truck stopped");
    }   
    @Override
    public void getType(){
        System.out.println("Truck");
    }

}
