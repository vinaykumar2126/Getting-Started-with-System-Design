package ECommerceOrderProcessingSystem;
import java.util.*;

public class Order implements Subject {
    private Orderstatus status;
    private int amount;
    private int id;
    private List<Observer> observers;

    public Order(int id, int amount) {
        observers = new ArrayList<>();
        this.id = id;
        this.amount = amount;
    }

    public int getAmount() { return amount; }
    public int getId() { return id; }
    public Orderstatus getStatus() { return status; }

    public void place(Orderstatus status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) { observers.add(o); }
    @Override
    public void removeObserver(Observer o) { observers.remove(o); }
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this, status);
        }
    }
}