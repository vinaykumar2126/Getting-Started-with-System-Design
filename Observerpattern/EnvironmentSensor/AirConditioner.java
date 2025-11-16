package EnvironmentSensor;

public class AirConditioner implements Observer {
    @Override
    public void update(SensorUpdate update) {
        //type-casting to specific update type
        if (update instanceof EnvironmentUpdate && "TEMPERATURE_CHANGE".equals(update.getUpdateType())) {
            EnvironmentUpdate envUpdate = (EnvironmentUpdate) update;
            int newTemp = envUpdate.getNewValue();
            System.out.println("Air Conditioner: Adjusting for new temperature: " + newTemp);
            if (newTemp > 25) {
                System.out.println("Air Conditioner is ON");
                System.out.println("Current Temperature: " + update.getSensor().getTemperature());
                System.out.println(update.updateType + " from " + envUpdate.getOldValue() + " to " + envUpdate.getNewValue());
            } else {
                System.out.println("Air Conditioner is OFF");
            }
        }
    }
}