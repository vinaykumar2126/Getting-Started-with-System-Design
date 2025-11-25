package Food_Delivery_App;

public class Mushrooms extends FoodItemDecorator{
    private double extraPrice;
    public Mushrooms(FoodItem item, double extraPrice) {
        super(item);
        this.extraPrice = extraPrice;
    }
    @Override
    public String getDescription() { return foodItem.getDescription() + ", Mushrooms"; }
    @Override
    public double getPrice() { return foodItem.getPrice() + extraPrice; }
}
