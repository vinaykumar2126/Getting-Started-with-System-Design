package Payment_System;

public class Upi implements PaymentStrategy{
    @Override
    public String pay(int amount){
        return "Paid "+amount+" using UPI";
    }
}
