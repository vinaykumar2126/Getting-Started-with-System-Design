package EnvironmentSensor;

public class SecuritySystem implements Observer{

   @Override
    public void update(SensorUpdate update) {
        if (update instanceof EnvironmentUpdate && "TEMPERATURE_CHANGE".equals(update.getUpdateType())) {
            EnvironmentUpdate envUpdate = (EnvironmentUpdate) update;
            int newTemp = envUpdate.getNewValue();
            System.out.println("Security System: Monitoring temperature: " + newTemp);
            if (newTemp < 18 || newTemp > 25) {
                triggerAlarm();
            }
        }
    }

    private void triggerAlarm() {
        System.out.println("Security System: Alarm triggered!");
    }
}
