package LibraryBookAvailabilitySystem;
import java.util.*;

public class book implements Subject {
    private String title;
    private Bookstatus status;
    private List<Observer> observers = new ArrayList<>();

    public book(String title, Bookstatus status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() { return title; }
    public Bookstatus getStatus() { return status; }

    public void setStatus(Bookstatus status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) { observers.add(o); }
    @Override
    public void unregisterObserver(Observer o) { observers.remove(o); }
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this); // Pass the book object
        }
    }
}