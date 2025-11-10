package ECommerceOrderProcessingSystem;

public class Paymentfactory {
    private static final PaymentStrategy creditCard = new Creditcard();
    private static final PaymentStrategy paypal = new Paypal();
    public static PaymentStrategy getPaymentMethod(String type) {
        if (type.equalsIgnoreCase("CreditCard")) {
            return creditCard;
        } else if (type.equalsIgnoreCase("PayPal")) {
            return paypal;
        }
        return null;
    }
    
}
