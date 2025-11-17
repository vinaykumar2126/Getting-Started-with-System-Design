package Food_Delivery_App;

public class Restaurant extends User{
    public Restaurant(String id, String name, String contact){
        super(id, name, contact);
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }

    
}


