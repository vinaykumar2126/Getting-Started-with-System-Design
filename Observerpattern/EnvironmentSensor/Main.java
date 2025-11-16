package EnvironmentSensor;
//push example of Observer Pattern
public class Main {
    public static void main(String args[]){
        EnvironmentSensor sensor = new EnvironmentSensor();
        AirConditioner ac = new AirConditioner(); //AC Needs sensor data, AC Depends on sensor
        SecuritySystem ss = new SecuritySystem(); // Security System Needs sensor data, Security System Depends on sensor
        sensor.connect(ac);
        sensor.connect(ss);
        sensor.setTemperature(30);
        
    }
}

