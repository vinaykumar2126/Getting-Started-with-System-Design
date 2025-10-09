package NewsNotificationSystem;

public interface Subject {//Observable 
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}
