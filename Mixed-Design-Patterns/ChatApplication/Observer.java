package ChatApplication;

public interface Observer {
    void update(String senderName,String message);
    String getName();
}
