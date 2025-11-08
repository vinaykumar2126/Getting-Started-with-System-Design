package ChatApplication;

public class User implements Observer {
    private String name;
    
    public User(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void update(String senderName, String message) {
        System.out.println("[" + name + " received] " + senderName + ": " + message);
    }
    
    // ✅ User sends message WITHOUT knowing about broker!
    public void sendMessage(String message, User receiver) {
        SendMessageCommand cmd = new SendMessageCommand(this, receiver, message);
        cmd.execute();  // Command handles broker internally!
    }
}
