package ECommerceOrderProcessingSystem;

public class User implements Observer {
    @Override
    public void update(Order order, Orderstatus status) {
        switch(status){
            case PLACED:
                System.out.println("Your order #" + order.getId() + " has been placed.");
                break;
            case PAYMENT_CONFIRMED:
                System.out.println("Payment for order #" + order.getId() + " has been confirmed." + " Amount: " + order.getAmount());
                break;
            case SHIPPED:
                System.out.println("Your order #" + order.getId() + " has been shipped.");
                break;
            case DELIVERED:
                System.out.println("Your order #" + order.getId() + " has been delivered.");
                break;
            default:
                break;
        }
    }
}

