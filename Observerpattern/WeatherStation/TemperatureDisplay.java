package WeatherStation;

public class TemperatureDisplay implements WeatherDisplay {
    private WeatherStation station;

    public TemperatureDisplay(WeatherStation station) {
        this.station = station;
    }

    
    @Override
    public void update() {
        System.out.println("Temperature Display: " + station.getTemperature() + "°C");
    }
}