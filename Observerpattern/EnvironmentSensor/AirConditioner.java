package EnvironmentSensor;

public class AirConditioner implements Observer{
    private EnvironmentSensor sensor;
    public AirConditioner(EnvironmentSensor sensor){
        this.sensor = sensor;
    }
    @Override
    public void update() {
        System.out.println("Air Conditioner adjusting settings based on sensor data.");
        if(sensor.getTemperature() > 25){
            System.out.println("Air Conditioner is ON");
        } else {
            System.out.println("Air Conditioner is OFF");
        }
        
    }    
}
