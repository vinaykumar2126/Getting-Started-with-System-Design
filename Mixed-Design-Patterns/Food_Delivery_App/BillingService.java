package Food_Delivery_App;

public class BillingService {
    private PaymentStrategy strategy;
    private double amount;
    public BillingService(PaymentStrategy strategy, double amount){
        this.strategy = strategy;
        this.amount = amount;
        System.out.println("Processing payment of amount: $" + amount);
    }
    public boolean processPayment(){
        return strategy.pay(amount);
    }
    
}
