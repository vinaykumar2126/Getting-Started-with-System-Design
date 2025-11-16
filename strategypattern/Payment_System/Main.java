package Payment_System;

public class Main {
    public static void main(String args[]){
        // PaymentStrategy strategy = new Upi();
        ShoppingCart cart = new ShoppingCart(new Upi());
        System.out.println(cart.checkout(100));
        cart.setPaymentStrategy(new CreditCard());
        System.out.println(cart.checkout(200));
        
    }
    
}
