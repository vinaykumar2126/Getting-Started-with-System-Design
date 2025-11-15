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
//Final - Value can't change after assignmnet
//Static - Belongs to class not to an object of class
//Fields are also static because if not then we cannot send those variable to outside class without creating object of Paymentfactory class
//A public method can provide controlled access to private fields or methods from outside the class.
// This is called encapsulation—it hides internal details and exposes only what’s necessary.