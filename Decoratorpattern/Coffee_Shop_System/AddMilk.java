package Coffee_Shop_System;

public class AddMilk extends SimpleCoffee{
    protected Coffee coffee;
    public AddMilk(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public String getDescription() {
        return coffee.getDescription() + " milk";
    }
    @Override
    public double getCost() {
        return coffee.getCost() + 10.0;
    }
    
}
