package Food_Delivery_App;

public class Customer extends User{
    public Customer(String id, String name, String contact){
        super(id, name, contact);
    }
    public String getName(){
        return name;
    }
    public boolean payment(PaymentStrategy strategy,double amount){
        BillingService billingService = new BillingService(strategy,amount);
        return billingService.processPayment();
        
    }

    public Order placeOrder(User restaurant, FoodItem item, Deliverypartner.deliver deliveryType){
        Order order = new Order(restaurant, this, item, deliveryType);
        payment(new CreditCard(),100.0); // Assuming a fixed amount for simplicity
        System.out.println("Order placed by "+this.name+" to "+((Restaurant) restaurant).getName()+" for item "+item.getDescription()+" with "+deliveryType+" delivery.");
        return order;
    }
    
}
