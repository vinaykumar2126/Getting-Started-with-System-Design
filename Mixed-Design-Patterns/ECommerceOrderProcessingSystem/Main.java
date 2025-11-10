package ECommerceOrderProcessingSystem;

public class Main {
    public static void main(String[] args) {
        // Create an order
        Order order = new Order(1, 1000);

        // Create observers
        User user = new User();
        Warehouse warehouse = new Warehouse();

        // Register observers
        order.registerObserver(user);
        order.registerObserver(warehouse);

        // Place order
        order.place(Orderstatus.PLACED);

        // Process payment using Factory to get strategy
        PaymentStrategy paymentMethod = Paymentfactory.getPaymentMethod("CreditCard");
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(order, paymentMethod);
        

        // Change order status to shipped
        order.place(Orderstatus.SHIPPED);

        // Change order status to delivered
        order.place(Orderstatus.DELIVERED);
    }
}
