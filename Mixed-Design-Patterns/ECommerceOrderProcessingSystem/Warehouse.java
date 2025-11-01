package ECommerceOrderProcessingSystem;

public class Warehouse implements Observer {
    @Override
    public void update(Order order, Orderstatus status) {
        System.out.println("Warehouse notified: Order #" + order.getId() + " status changed to " + status);
    }
}