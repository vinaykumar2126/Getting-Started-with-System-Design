package Payment_System;

public class Upi implements PaymentStrategy{
    public boolean test(int x){
        return x > 0;
    }
    @Override
    public String pay(int amount){
        return "Paid "+amount+" using UPI";
    }
}
