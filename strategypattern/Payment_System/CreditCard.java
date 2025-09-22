package Payment_System;

public class CreditCard implements PaymentStrategy{
    @Override
    public String pay(int amount){
        return "Paid "+amount+" using Credit Card";
    }
}

