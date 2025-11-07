package ChatApplication;

public class SendMessageCommand implements Command{
    private User sender;
    private User receiver;
    private String message;

    public SendMessageCommand(User sender, User receiver, String message){
        this.sender=sender;
        this.receiver = receiver;
        this.message=message;
    }
    @Override
    public void execute() {
        MessageBroker broker = MessageBroker.getInstance();
        broker.sendMessage(sender, receiver, message);
    }

    public void undo(){

    }
    
}
