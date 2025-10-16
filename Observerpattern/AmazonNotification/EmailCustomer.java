package AmazonNotification;

public class EmailCustomer implements Observer {
    private String email;
    
    public EmailCustomer(String email) {
        this.email = email;
    }
    
    @Override
    public void update(String message) {
        System.out.println("Sending email to " + email + ": " + message);
    }
}