package Food_Delivery_App;
import java.time.LocalTime;
public class RestaurantOpenValidator implements OrderValidator {
    private OrderValidator next;

    @Override
    public void setNext(OrderValidator next) {
        this.next = next;
    }

    @Override
    public boolean validate(Order order) {
        LocalTime currentTime = LocalTime.now();
        LocalTime openTime = LocalTime.of(10, 0); // Example: restaurant opens at 10 AM
        LocalTime closeTime = LocalTime.of(20, 0); // Example: restaurant closes at 8 PM
        boolean isOpen = currentTime.isAfter(openTime) && currentTime.isBefore(closeTime);
        if (!isOpen) {
            System.out.println("Restaurant is closed.");
            return false;
        }
        if (next != null) return next.validate(order);
        return true;
    }
}