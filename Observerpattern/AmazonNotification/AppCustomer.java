package AmazonNotification;

public class AppCustomer implements Observer {
    private String name;
    
    public AppCustomer(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        System.out.println("Sending push notification to " + name + ": " + message);
    }
}