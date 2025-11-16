/**
 * Defines a contract for any pricing model (Strategy Pattern).
 * This allows us to easily swap out different pricing calculations
 * (e.g., hourly, daily, weekend special) without changing the garage logic.
 */
package Advanced_parkingLot;

import Advanced_parkingLot.Ticket;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket);
}