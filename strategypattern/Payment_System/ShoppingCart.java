package Payment_System;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    public ShoppingCart(PaymentStrategy strategy){
        this.paymentStrategy = strategy;
    }
    public String checkout(int amount){
        return paymentStrategy.pay(amount);
    }
}
