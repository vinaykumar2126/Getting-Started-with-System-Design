package Discount_Calculation_System;

public class Main {
    public static void main(String args[]){
        CalculationSystem calcSystem = new CalculationSystem((new StudentDiscount()));

        System.out.println(calcSystem.calculateFinalPrice(100));

    }
    
}
