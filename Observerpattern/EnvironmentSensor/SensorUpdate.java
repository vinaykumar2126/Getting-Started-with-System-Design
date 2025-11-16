package EnvironmentSensor;

// Abstract class because different types of sensor updates may have different data -
// and we can create different classes for the SensorUpdate for different updates like in this case we only show environment but later we can show other updates too like motion,pressure etc
public abstract class SensorUpdate {
    private EnvironmentSensor sensor;
    protected String updateType;

    public SensorUpdate(EnvironmentSensor sensor, String updateType) {
        this.sensor = sensor;
        this.updateType = updateType;
    }

    public EnvironmentSensor getSensor() {
        return sensor;
    }

    public abstract String getUpdateType();
}
