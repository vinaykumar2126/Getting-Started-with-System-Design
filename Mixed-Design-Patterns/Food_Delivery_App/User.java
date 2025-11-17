package Food_Delivery_App;

public abstract class User {
    protected String id;
    protected String name;
    protected String contact;

    public User(String id, String name, String contact){
        this.id=id;
        this.name=name;
        this.contact=contact;
    }
}

