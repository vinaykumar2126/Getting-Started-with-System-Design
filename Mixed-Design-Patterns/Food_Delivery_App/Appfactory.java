package Food_Delivery_App;

public class Appfactory {
    public static User createUser(String userType,String id,String name, String contact){
        if(userType.equals("Customer")){
            return new Customer(id,name,contact);
        }
        if(userType.equals("Restaurant")){
            return new Restaurant(id,name,contact);
        }
        if(userType.equals("Deliverypartner")){
            return new Deliverypartner(id,name,contact);
        }
        return null;
    }

}
