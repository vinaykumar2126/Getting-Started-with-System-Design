package EnvironmentSensor;
import java.util.*;
public class EnvironmentSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;
    private int humidity;
    private int lightLevel;
    public EnvironmentSensor() {
    }
    public int getTemperature(){
        return temperature;
    }
    public void setTemperature(int temperature){
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void connect(Observer o) {
        observers.add(o);
        System.out.println("Observer connected.");
        o.update();
    }

    @Override
    public void disconnect(Observer o) {
        observers.remove(o);
        System.out.println("Observer disconnected.");
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }
}
