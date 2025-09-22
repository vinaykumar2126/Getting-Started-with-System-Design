package Payment_System;

public class Cash implements PaymentStrategy{
    @Override
    public String pay(int amount){
        return "Paid "+amount+" using Cash";
    }
    
}
