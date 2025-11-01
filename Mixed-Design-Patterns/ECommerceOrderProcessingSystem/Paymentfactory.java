package ECommerceOrderProcessingSystem;

public class Paymentfactory {
    public static PaymentStrategy getPaymentMethod(String type) {
        if (type.equalsIgnoreCase("CreditCard")) {
            return new Creditcard();
        } else if (type.equalsIgnoreCase("PayPal")) {
            return new Paypal();
        }
        return null;
    }
    
}
