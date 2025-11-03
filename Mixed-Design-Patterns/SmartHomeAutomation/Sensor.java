package SmartHomeAutomation;
import java.util.*;

public class Sensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String sensorType;
    private boolean motionDetected;
    private int temperature; 
    public Sensor(String sensorType){
        this.sensorType = sensorType;
        this.motionDetected = false;
        this.temperature = 25;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("Device registered to " + sensorType + " sensor");

    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        System.out.println("\n[" + sensorType + " Sensor] State changed! Notifying all devices...");
        for (Observer o : observers) {
            o.update(sensorType, motionDetected, temperature);
        }
    }
    public void detectMotion() {
        System.out.println("\n[" + sensorType + " Sensor] Motion detected!");
        this.motionDetected = true;
        notifyObservers();  // ← This triggers the notification!
    }

    public void setTemperature(int temp) {
        System.out.println("\n[" + sensorType + " Sensor] Temperature changed to " + temp + "°C");
        this.temperature = temp;
        notifyObservers();  // ← This triggers the notification!
    }
    public boolean isMotionDetected() {
        return motionDetected;
    }
    
    public int getTemperature() {
        return temperature;
    }
    
    
}
