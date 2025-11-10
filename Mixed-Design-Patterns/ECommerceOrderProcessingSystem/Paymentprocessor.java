package ECommerceOrderProcessingSystem;

class PaymentProcessor {
    public void processPayment(Order order, PaymentStrategy paymentMethod) {
        // Process payment based on the selected payment method
        paymentMethod.pay(order.getAmount());
        order.place(Orderstatus.PAYMENT_CONFIRMED);
    }
}
    


