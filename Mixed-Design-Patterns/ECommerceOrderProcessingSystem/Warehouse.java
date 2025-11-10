package ECommerceOrderProcessingSystem;

public class Warehouse implements Observer {
    @Override
    public void update(Order order, Orderstatus status) {
        switch(status){
            case PLACED:
                System.out.println("Warehouse: " + order.getId() + " Placed Successfully");
                break;
            case PAYMENT_CONFIRMED:
                System.out.println("Warehouse: Payment confirmed for order #" + order.getId() + ". Packing the order.");
                break;
            case SHIPPED:
                System.out.println("Warehouse: Order #" + order.getId() + " has been shipped.");
                break;
            case DELIVERED:
                System.out.println("Warehouse: Order #" + order.getId() + " has been delivered.");
                break;
            default:
                break;
        }
    }
}