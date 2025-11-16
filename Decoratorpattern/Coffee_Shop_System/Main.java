package Coffee_Shop_System;

public class Main {
    public static void main(String args[]){
        Coffee coffee = new SimpleCoffee();
        Coffee addmilk = new AddMilk(coffee);
        System.out.println(addmilk.getDescription() + " $" + addmilk.getCost());
    }
    
}

