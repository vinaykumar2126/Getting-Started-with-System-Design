package ChatApplication;

public class MessageBroker {
    private static MessageBroker instance;
    private MessageBroker(){}

    public static synchronized MessageBroker getInstance(){
        if(instance==null){
            instance = new MessageBroker();
        }
        return instance;
    }
    public void registerUser(User user){

    }
    // ✅ THIS WAS MISSING! Send message from sender to receiver
    public void sendMessage(User sender, User receiver, String message) {
        System.out.println("[MessageBroker] Routing message from " + sender.getName() + " to " + receiver.getName());
        // Notify receiver (Observer pattern!)
        receiver.update(sender.getName(), message);
    }
    
    public void execute(SendMessageCommand messagecommand){
        messagecommand.execute();

    }
   

}
    

