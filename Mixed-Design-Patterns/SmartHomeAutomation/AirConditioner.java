package SmartHomeAutomation;

public class AirConditioner implements Observer{
    private String location;
    private boolean isOn;
    private int temperature;
    
    public AirConditioner(String location) {
        this.location = location;
        this.isOn = false;
        this.temperature = 24;
    }
    @Override
    public void update(String sensorType, boolean motionDetected, int temperature) {
        if (temperature > 28) {
            turnOn();
            setTemperature(22);
            System.out.println("  " + location + " AC auto-turned ON (temp too high: " + temperature + "°C)");
        } else if (temperature < 20) {
            turnOff();
            System.out.println("  " + location + " AC auto-turned OFF (temp comfortable: " + temperature + "°C)");
        }
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(location + " AC is ON at " + temperature + "°C");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(location + " AC is OFF");
    }
    
    public void setTemperature(int temp) {
        this.temperature = temp;
        if (isOn) {
            System.out.println(location + " AC temperature set to " + temp + "°C");
        }
    }
    
    public int getTemperature() {
        return temperature;
    }
   
}