package EnvironmentSensor;

public class EnvironmentUpdate extends SensorUpdate {
    private int oldValue;
    private int newValue;

    public EnvironmentUpdate(EnvironmentSensor sensor, String updateType, int oldValue, int newValue) {
        super(sensor, updateType);
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public int getOldValue() {
        return oldValue;
    }

    public int getNewValue() {
        return newValue;
    }
    @Override
    public String getUpdateType(){
        return updateType;
    }
    
}
