package Coffee_withaddons;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);   // add milk
        System.out.println(coffee.getDescription()+ " $" + coffee.getCost());
        coffee = new SugarDecorator(coffee);  // add sugar
        

        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
