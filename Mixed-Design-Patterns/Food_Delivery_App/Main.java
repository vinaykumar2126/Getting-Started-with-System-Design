package Food_Delivery_App;

public class Main {
    public static void main(String[] args){
        System.out.println("Food Delivery App Started");
        User customer = Appfactory.createUser("Customer","123","Vinay","607-555-1234");
        User restaurant = Appfactory.createUser("Restaurant", "R456", "Pizza Place", "8888888888");
        User deliveryPartner = Appfactory.createUser("Deliverypartner", "D789", "Bob", "7777777777");

        Order order=((Customer) customer).placeOrder(restaurant, "Pizza Margherita",Deliverypartner.deliver.Fast);
        ((Deliverypartner) deliveryPartner).deliverOrder(order);

    }
    
}
