package Advanced_parkingLot.Strategy;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * A specific implementation of PricingStrategy that charges by the hour.
 */
public class HourlyPricing implements PricingStrategy {
    private final double RATE_PER_HOUR = 4.50; // $4.50 per hour

    @Override
    public double calculatePrice(Ticket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        // Calculate the duration between entry and exit.
        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        long hours = duration.toHours();

        // Business Rule: Always charge for at least one hour.
        if (duration.toMinutes() > 0 && hours == 0) {
            hours = 1;
        } 
        // Business Rule: Round up to the next hour (e.g., 1 hour and 5 minutes is charged as 2 hours).
        else if (duration.toMinutes() % 60 > 0) {
            hours++;
        }
        
        return hours * RATE_PER_HOUR;
    }
}