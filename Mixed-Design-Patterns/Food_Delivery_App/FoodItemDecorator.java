package Food_Delivery_App;

public abstract class FoodItemDecorator implements FoodItem{
    protected FoodItem foodItem;
    public FoodItemDecorator(FoodItem foodItem){
        this.foodItem = foodItem;
    }
}
