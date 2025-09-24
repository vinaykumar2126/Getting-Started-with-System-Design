package Discount_Calculation_System;

public class LoyaltyDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount){
        return amount * 0.9; // 10% loyalty discount
    }
    
}
