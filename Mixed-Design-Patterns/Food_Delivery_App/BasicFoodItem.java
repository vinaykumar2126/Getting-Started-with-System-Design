package Food_Delivery_App;

public class BasicFoodItem implements FoodItem {
    private String pizza;
    private double price;
    public BasicFoodItem(String pizza, double v) {
        this.pizza = pizza;
        this.price = v;
    }
    @Override
    public String getDescription() { return pizza; }
    @Override
    public double getPrice() { return price; }
}
