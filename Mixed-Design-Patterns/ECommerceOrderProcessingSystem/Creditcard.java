package ECommerceOrderProcessingSystem;

public class Creditcard implements PaymentStrategy {
    @Override
    public void pay(Order order) {
        System.out.println("Paid " + order.getAmount() + " using Credit Card.");
    }
}
