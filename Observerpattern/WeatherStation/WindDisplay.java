package WeatherStation;

public class WindDisplay implements WeatherDisplay {
    private WeatherStation station;

    public WindDisplay(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        System.out.println("Wind Display: " + station.getWindSpeed() + " km/h");
    }
}