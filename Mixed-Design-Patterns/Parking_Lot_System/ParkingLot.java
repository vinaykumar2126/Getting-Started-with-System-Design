package Parking_Lot_System;

import java.util.*;
public class ParkingLot {
    private ParkingStrategy strategy;
    HashMap<String,Integer> licensePlateToSpotMap;
    HashMap<Integer,ParkingSpot> spot_track;
    PriorityQueue<Integer> available = new PriorityQueue<>();
    public ParkingLot(int totalSpots){
        licensePlateToSpotMap = new HashMap<>();
        spot_track = new HashMap<>();
        available = new PriorityQueue<>();

        for(int i=1;i<=totalSpots;i++){
            ParkingSpot.SpotType type; 
            if(i%10==0){
                type = ParkingSpot.SpotType.HANDICAPPED;
            } else if(i%3==0){
                type = ParkingSpot.SpotType.LARGE;
            } else if (i%2==0){
                type = ParkingSpot.SpotType.SMALL;
            }
            else{
                type = ParkingSpot.SpotType.REGULAR;
            }
            ParkingSpot spot = ParkingSpotFactory.createSpot(type,i);
            spot_track.put(i,spot);
            available.offer(i);//add spots to the available spots queue
        }
    }
    public void setStrategy(ParkingStrategy strategy){
        this.strategy = strategy;
    }
    public int findSpotAndParkVehicle(Vehicle vehicle){
        while (available.isEmpty()){
            return -1; //no spots available
        }
        int spotNumber = strategy.findSpot(available,vehicle.getVehicleType(),spot_track);
        ParkingSpot spot = spot_track.get(spotNumber);
        spot.Park(vehicle);
        licensePlateToSpotMap.put(vehicle.getVehicleNumber(),spotNumber);
        return spotNumber;
        
    }

    public boolean checkoutVehicle(Vehicle vehicle){
        while(licensePlateToSpotMap.containsKey(vehicle.getVehicleNumber())==false){
            return false;
        }
        int spotNumber = licensePlateToSpotMap.remove(vehicle.getVehicleNumber());
        ParkingSpot spot = spot_track.get(spotNumber);
        spot.unPark();
        available.offer(spotNumber);
        return true;

    }
}


