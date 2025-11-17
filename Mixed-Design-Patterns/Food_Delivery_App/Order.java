package Food_Delivery_App;

public class Order {
    private User restaurant;
    private User customer;
    private String item;
    private Deliverypartner.deliver deliveryType;
    public Order(User restaurant, User customer, String item, Deliverypartner.deliver deliveryType){
        // Initialize order with restaurant, customer, item and delivery type
        this.restaurant = restaurant;
        this.customer = customer;
        this.item = item;
        this.deliveryType = deliveryType;
    }
    public User getRestaurant(){
        return restaurant;
    }
    public String getCustomer(){
        return ((Customer) customer).getName();
    }
    public String getItem(){
        return item;
    }
    public Deliverypartner.deliver getDeliveryType(){
        return deliveryType;
    }
}
