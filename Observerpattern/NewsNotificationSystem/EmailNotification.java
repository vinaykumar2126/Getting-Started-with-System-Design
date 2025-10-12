package NewsNotificationSystem;

public class EmailNotification implements Observer{
    private String emailAddress;

    public EmailNotification(String emailAddress){
        this.emailAddress = emailAddress;
    }
    @Override
    public void update(String news){
        System.out.println("EmailNotification - " + emailAddress + " received news update: " + news);
    }
    @Override
    public String getName() {
        return emailAddress;
    }

    
}
