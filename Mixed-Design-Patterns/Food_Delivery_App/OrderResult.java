package Food_Delivery_App;

public class OrderResult {
    private boolean success;
    private String message;
    private Order order;

    public OrderResult(boolean success, String message, Order order) {
        this.success = success;
        this.message = message;
        this.order = order;
    }
    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }
    public Order getOrder() {
        return order;
    }
}
