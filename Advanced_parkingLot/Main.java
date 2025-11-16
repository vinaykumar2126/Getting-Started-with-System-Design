/**
 * This is the driver class to run a simulation of the parking garage.
 */
package Advanced_parkingLot;

import Advanced_parkingLot.Strategy.HourlyPricing;
import Advanced_parkingLot.Strategy.PricingStrategy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // --- 1. SETUP ---
        // Choose the pricing model we want to use.
        PricingStrategy hourlyPricing = new HourlyPricing();
        // Create a new garage instance with 2 floors, 10 spots per floor, and our chosen pricing.
        ParkingGarage garage = new ParkingGarage(2, 10, hourlyPricing);

        // --- 2. CREATE VEHICLES ---
        Car car1 = new Car("ABC-123", VehicleType.SMALL);
        Car car2 = new Car("XYZ-789", VehicleType.LARGE);

        // --- 3. PARK CARS ---
        System.out.println("--- Parking Cars ---");
        Ticket ticket1 = garage.park(car1);
        Ticket ticket2 = garage.park(car2);
        
        // --- 4. SIMULATE TIME PASSING ---
        System.out.println("\n--- Waiting for some time ---");
        // Pause the program for 2000 milliseconds (2 seconds) to simulate parking duration.
        Thread.sleep(2000); 

        // --- 5. UNPARK CARS ---
        System.out.println("\n--- Unparking Cars ---");
        if (ticket1 != null) {
            garage.unpark(ticket1.getTicketId());
        }
        if (ticket2 != null) {
            garage.unpark(ticket2.getTicketId());
        }
    }
}
