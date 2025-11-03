package SmartHomeAutomation;

public interface Observer {
    void update(String sensorType, boolean motionDetected, int temperature);
}
