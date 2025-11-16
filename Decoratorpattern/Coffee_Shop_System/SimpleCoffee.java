package Coffee_Shop_System;

public class SimpleCoffee implements Coffee{
    // protected Coffee coffee;

    @Override
    public String getDescription() {
        return "coffee with decorator";
    }
    @Override
    public double getCost() {
        return 50.0;
    }
    
}
