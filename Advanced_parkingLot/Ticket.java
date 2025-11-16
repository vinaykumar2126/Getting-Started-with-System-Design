import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a parking ticket issued to a car upon entry.
 * This is a data object that stores session information.
 */
package Advanced_parkingLot;
public class Ticket {
    // --- Fields ---
    private String ticketId;
    private LocalDateTime entryTime;
    private ParkingSpot spot; // Links the ticket to the specific spot.

    // --- Constructor ---
    public Ticket(ParkingSpot spot) {
        // Generate a short, unique random ID for the ticket.
        this.ticketId = UUID.randomUUID().toString().substring(0, 8);
        this.entryTime = LocalDateTime.now(); // Record the time of creation.
        this.spot = spot;
    }

    // --- Getters ---
    public String getTicketId() { return ticketId; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public ParkingSpot getSpot() { return spot; }
}
