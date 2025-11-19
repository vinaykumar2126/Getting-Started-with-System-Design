package Food_Delivery_App;

public class CreditCard implements PaymentStrategy {
    @Override
    public boolean pay(double amount){
        System.out.println("Paid $" + amount + " using Credit Card.");
        return true;
    }
    
}

