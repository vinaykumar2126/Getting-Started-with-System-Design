package Food_Delivery_App;

public class ExtraCheese extends FoodItemDecorator {
    private double extraPrice;
    public ExtraCheese(FoodItem item, double extraPrice) {
        super(item);
        this.extraPrice = extraPrice;
    }
    public String getDescription() { return foodItem.getDescription() + ", Extra Cheese"; }
    public double getPrice() { return foodItem.getPrice() + extraPrice; }
}

