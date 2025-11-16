import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
package Advanced_parkingLot;
/**
 * The main class that orchestrates the entire parking garage operation.
 * It manages floors, handles ticketing, and processes payments.
 */
public class ParkingGarage {
    // --- Fields ---
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets; // Stores currently parked cars' tickets.
    private PricingStrategy pricingStrategy; // The current pricing model.

    // --- Constructor ---
    public ParkingGarage(int numFloors, int spotsPerFloor, PricingStrategy pricingStrategy) {
        this.floors = new ArrayList<>();
        // Build the garage by creating its floors.
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new ParkingFloor(i, spotsPerFloor));
        }
        this.pricingStrategy = pricingStrategy; // Set the pricing model.
        this.activeTickets = new HashMap<>();
    }

    // --- Public Methods ---
    /**
     * Handles the process of parking a car.
     * It delegates the task of finding a spot to its floors.
     * If successful, it creates and returns a ticket.
     */
    public Ticket park(Car car) {
        // Iterate through all floors to find a spot.
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAndPark(car);
            // If a spot was found on this floor...
            if (spot != null) {
                // Create a new ticket for this session.
                Ticket ticket = new Ticket(spot);
                // Store the ticket in our active tickets map.
                activeTickets.put(ticket.getTicketId(), ticket);
                System.out.println("Ticket issued: " + ticket.getTicketId());
                return ticket;
            }
        }
        System.out.println("Sorry, the garage is full.");
        return null; // Return null if no spot was found in the entire garage.
    }

    /**
     * Handles the process of a car leaving.
     * It calculates the cost, frees the spot, and removes the ticket.
     */
    public double unpark(String ticketId) {
        // Check if the ticket is valid.
        if (!activeTickets.containsKey(ticketId)) {
            System.out.println("Invalid ticket ID.");
            return 0.0;
        }

        // Retrieve the ticket.
        Ticket ticket = activeTickets.get(ticketId);
        // Use the pricing strategy to calculate the cost.
        double cost = pricingStrategy.calculatePrice(ticket);
        
        // Get the spot from the ticket and tell it to remove the car.
        ParkingSpot spot = ticket.getSpot();
        spot.removeCar();
        
        // Remove the ticket from the active list.
        activeTickets.remove(ticketId);

        System.out.println("Car unparked. Cost: $" + String.format("%.2f", cost));
        return cost;
    }
}