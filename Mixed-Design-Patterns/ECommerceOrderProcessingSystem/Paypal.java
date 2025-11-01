package ECommerceOrderProcessingSystem;

public class Paypal implements PaymentStrategy {
    @Override
    public void pay(Order order) {
        System.out.println("Paid " + order.getAmount() + " using PayPal.");
    }
    
}
