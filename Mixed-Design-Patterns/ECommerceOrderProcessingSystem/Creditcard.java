package ECommerceOrderProcessingSystem;

public class Creditcard implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

