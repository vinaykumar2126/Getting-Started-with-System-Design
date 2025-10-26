package EnvironmentSensor;
import java.util.*;
public class EnvironmentSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private EnvironmentUpdate lastUpdate;
    private int temperature;
    private int humidity;
    private int lightLevel;
    public EnvironmentSensor() {
    }
    public int getTemperature(){
        return temperature;
    }
    public void setTemperature(int newTemperature){
        int oldTemperature = this.temperature;
        this.temperature = newTemperature;
        notifyObservers(new EnvironmentUpdate(this, "TEMPERATURE_CHANGE", oldTemperature, newTemperature));
    }

    @Override
    public void connect(Observer o) {
        observers.add(o);
        System.out.println("Observer connected.");
    }

    @Override
    public void disconnect(Observer o) {
        observers.remove(o);
        System.out.println("Observer disconnected.");
    }

    @Override
    public void notifyObservers(SensorUpdate update) {
        for(Observer observer : observers) {
            observer.update(update);
        }
    }
}
