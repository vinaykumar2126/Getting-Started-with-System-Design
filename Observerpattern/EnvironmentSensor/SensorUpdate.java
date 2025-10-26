package EnvironmentSensor;

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
