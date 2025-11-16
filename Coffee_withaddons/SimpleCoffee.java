package Coffee_withaddons;

public class SimpleCoffee implements Coffee{
    @Override
    public String getDescription(){
        return "SimpleCoffee";
    }
    @Override
    public double getCost(){
        return 2.0;
    }

}

