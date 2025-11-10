package ECommerceOrderProcessingSystem;

public class Paypal implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
    
}
