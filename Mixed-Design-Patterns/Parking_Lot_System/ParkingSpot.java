package Parking_Lot_System;
import java.util.*;

public class ParkingSpot {
    public enum SpotType{
    SMALL,
    HANDICAPPED,
    LARGE,
    REGULAR
    }
    private int spotnumber;
    private SpotType spotType;
    boolean isOccupied;
    public Vehicle vehicle;

    public ParkingSpot(SpotType spotType,int spotnumber){
        this.isOccupied = false;
        this.spotType = spotType;
        this.spotnumber = spotnumber;
    }
    public SpotType getSpotType(){
        return spotType;
    }
    public boolean isOccupied(){
        return isOccupied;
    }
    public void Park(Vehicle vehicle){
        this.vehicle = vehicle;
        isOccupied = true;
    }
    public void unPark(){
        this.vehicle = null;
        isOccupied = false;
    }
}
