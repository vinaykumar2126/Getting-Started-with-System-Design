package Food_Delivery_App;

public class Customer extends User{
    public Customer(String id, String name, String contact){
        super(id, name, contact);
    }
    public String getName(){
        return name;
    }

    public Order placeOrder(User restaurant, String item, Deliverypartner.deliver deliveryType){
        Order order = new Order(restaurant, this, item, deliveryType);
        System.out.println("Order placed by "+this.name+" to "+((Restaurant) restaurant).getName()+" for item "+item+" with "+deliveryType+" delivery.");
        return order;
    }
    
}
