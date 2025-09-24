package Discount_Calculation_System;

public class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.8; // 20% seasonal discount
    }
    
}
