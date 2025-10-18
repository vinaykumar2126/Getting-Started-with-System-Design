package TaskManager;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(TaskUpdate task);
}
