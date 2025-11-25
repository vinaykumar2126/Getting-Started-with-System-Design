package Food_Delivery_App;

public class ItemAvailableValidator implements OrderValidator {
    private OrderValidator next;

    @Override
    public void setNext(OrderValidator next) {
        this.next = next;
    }

    @Override
    public boolean validate(Order order) {
        // Example logic: always available for demo
        boolean available = true; // Replace with real check
        if (!available) {
            System.out.println("Item not available.");
            return false;
        }
        if (next != null) return next.validate(order);
        return true;
    }
}