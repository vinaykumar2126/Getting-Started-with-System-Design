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

// Factory created stateegies are stateless because they don't maintain any internal state that changes over time. So, safe to share among with multiple threads(Users) without synchronization issues.
// Stateless - No internal state, so it can be shared across multiple threads without synchronization issues.
// Here, CreditCard and PayPal are stateless because they don't maintain any internal state that changes over time. 
// They simply implement the PaymentStrategy interface and provide a way to process payments. 
// This allows us to create a single instance of each payment method and reuse it across the application without worrying about thread safety or synchronization issues.

// Stateful - Maintains internal state that can change over time, which may require synchronization when accessed by multiple threads.