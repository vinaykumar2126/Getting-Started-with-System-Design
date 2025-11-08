package ChatApplication;

public class Main {
    public static void main(String args[]) {
        MessageBroker broker = MessageBroker.getInstance();
        
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");
        
        // Register users
        broker.registerUser(alice);
        broker.registerUser(bob);
        broker.registerUser(charlie);
        
        // ✅ Bob sends message - doesn't know about broker!
        bob.sendMessage("Hello Charlie!", charlie);
        broker.broadcastMessage(alice, "Meeting at 3 PM!");

        
        // ✅ Alice sends message - doesn't know about broker!
        alice.sendMessage("Hi Bob!", bob);
        
        // ✅ Clean! User only calls sendMessage()!
    }
}