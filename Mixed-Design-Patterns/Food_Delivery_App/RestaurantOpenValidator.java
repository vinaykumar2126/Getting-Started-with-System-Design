package Food_Delivery_App;

public class RestaurantOpenValidator implements OrderValidator {
    private OrderValidator next;

    @Override
    public void setNext(OrderValidator next) {
        this.next = next;
    }

    @Override
    public boolean validate(Order order) {
        // Example logic: always open for demo
        boolean isOpen = false; // Replace with real check
        if (!isOpen) {
            System.out.println("Restaurant is closed.");
            return false;
        }
        if (next != null) return next.validate(order);
        return true;
    }
}