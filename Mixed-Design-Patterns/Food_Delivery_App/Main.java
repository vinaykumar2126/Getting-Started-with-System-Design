package Food_Delivery_App;

public class Main {
    public static void main(String[] args){
        System.out.println("Food Delivery App Started");
        User customer = Appfactory.createUser("Customer","123","Vinay","607-555-1234");
        User restaurant = Appfactory.createUser("Restaurant", "R456", "Pizza Place", "8888888888");
        User deliveryPartner = Appfactory.createUser("Deliverypartner", "D789", "Bob", "7777777777");
        FoodItem item = new BasicFoodItem("Pizza", 15.0);
        item = new ExtraCheese(item, 2.0);
        item = new Mushrooms(item, 3.0); // Adding extra cheese

        OrderResult result=((Customer) customer).placeOrder(restaurant,item,Deliverypartner.deliver.Fast);
        if(result.isSuccess()){
            System.out.println("Order Successful: " + result.getMessage());
            Order order = result.getOrder();
            ((Deliverypartner) deliveryPartner).deliverOrder(order);
        }else{
            System.out.println("Order Failed: " + result.getMessage());
        }
        
    }
    
}

