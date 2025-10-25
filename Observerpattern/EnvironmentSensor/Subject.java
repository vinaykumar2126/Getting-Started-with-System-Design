package EnvironmentSensor;

public interface Subject {
    void connect(Observer o);
    void disconnect(Observer o);
    void notifyObservers();
}
