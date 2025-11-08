package ChatApplication;
import java.util.*;
// Director Observer Pattern like WhatsApp, DM, Email does not need registration
public class MessageBroker {
    private static MessageBroker instance;
    private List<User> users;
    private MessageBroker(){
        users = new ArrayList<>();
    }

    public static synchronized MessageBroker getInstance(){
        if(instance==null){
            instance = new MessageBroker();
        }
        return instance;
    }
    public void registerUser(User user){
        users.add(user);

    }
    public void broadcastMessage(User sender , String message){
        for(User user : users){
            if(!user.equals(sender)){
                user.update(sender.getName(), message);
            }
        }
    }
    // ✅ THIS WAS MISSING! Send message from sender to receiver
    public void sendMessage(User sender, User receiver, String message) {
        System.out.println("[MessageBroker] Routing message from " + sender.getName() + " to " + receiver.getName());
        // Notify receiver (Observer pattern!)
        receiver.update(sender.getName(), message);
    }
    


   

}
    

