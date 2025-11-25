package Food_Delivery_App;

public interface OrderValidator {
    boolean validate(Order order);
    void setNext(OrderValidator nextValidator);
}

