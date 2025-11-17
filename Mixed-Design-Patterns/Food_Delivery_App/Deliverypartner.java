package Food_Delivery_App;

public class Deliverypartner extends User{
    public enum deliver{
        Fast,Normal,Economic
    }
    public Deliverypartner(String id, String name, String contact){
        super(id, name, contact);
    }
    public Deliverypartner getDeliverType(deliver type){
        // Logic to return delivery partner based on type
        return this;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void deliverOrder(Order order){
        System.out.println("Order delivered by "+this.name+" to "+order.getCustomer()+" for item "+order.getItem()+" with "+order.getDeliveryType()+" delivery.");
        // Logic to deliver the order
    }
    
}
