package EnvironmentSensor;

public class Main {
    public static void main(String args[]){
        EnvironmentSensor sensor = new EnvironmentSensor();
        AirConditioner ac = new AirConditioner(sensor); //AC Needs sensor data, AC Depends on sensor
        sensor.connect(ac);
        sensor.setTemperature(30);
    }
}

// Dependency Direction Explanation: when u revisit pls go through this you will get it better
// Ask yourself: "Which object would break if the other didn't exist?"

// AC without Sensor? Broken ❌
// Sensor without AC? Still works ✅