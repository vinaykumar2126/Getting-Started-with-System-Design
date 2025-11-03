package SmartHomeAutomation;

public class Light implements Observer {
    private String location;
    private boolean isOn;
    
    public Light(String location) {
        this.location = location;
        this.isOn = false;
    }
    @Override
    public void update(String sensorType, boolean motionDetected, int temperature) {
        // React to sensor changes
        if (motionDetected) {
            turnOn();
            System.out.println("  → " + location + " light auto-turned ON (motion detected)");
        }
    }
    public void turnOn() {
        isOn = true;
        System.out.println(location + " light is ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(location + " light is OFF");
    }
    
    public boolean isOn() {
        return isOn;
    }
}