package Discount_Calculation_System;

public class StudentDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount){
        return amount * 0.85; // 15% student discount
    }
    
}
