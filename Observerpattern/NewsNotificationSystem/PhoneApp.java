package NewsNotificationSystem;

public class PhoneApp implements Observer{
    private String userName;

    public PhoneApp(String userName){
        this.userName = userName;
    }
    @Override
    public void update(String news) {
        System.out.println("PhoneApp - " + userName + " received news update: " + news);
    }
    @Override
    public String getName() {
        return userName;
    }

    
}
