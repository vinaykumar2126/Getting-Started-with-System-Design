package Discount_Calculation_System;

public class CalculationSystem {
    private DiscountStrategy strategy;
    public CalculationSystem(DiscountStrategy strategy){
        this.strategy = strategy;
    }

    public double calculateFinalPrice(double originalPrice){
        return strategy.applyDiscount(originalPrice);
    }
}
