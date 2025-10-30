package WeatherStation;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        TemperatureDisplay tempDisplay = new TemperatureDisplay(station);
        WindDisplay windDisplay = new WindDisplay(station);

        station.addDisplay(tempDisplay);
        station.addDisplay(windDisplay);

        station.setWeather(25.5, 60.0, 12.3);
        station.setWeather(28.0, 55.0, 15.0);
    }
}

// Dependency Direction Explanation: when u revisit pls go through this you will get it better
// Ask yourself: "Which object would break if the other didn't exist?"

// tempDisplay without Weatherstation update no use? Broken 
// Sensor without AC? Still works 