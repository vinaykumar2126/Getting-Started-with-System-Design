package ECommerceOrderProcessingSystem;

public class User implements Observer {
    @Override
    public void update(Order order, Orderstatus status) {
        System.out.println("User notified: Order #" + order.getId() + " status changed to " + status + " with amount " + order.getAmount());
    }
}

