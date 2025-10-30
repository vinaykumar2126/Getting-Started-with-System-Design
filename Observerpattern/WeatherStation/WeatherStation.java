package WeatherStation;
import java.util.*;

public class WeatherStation {
    private List<WeatherDisplay> displays = new ArrayList<>();
    private double temperature;
    private double humidity;
    private double windSpeed;

    public void addDisplay(WeatherDisplay display) {
        displays.add(display);
    }

    public void removeDisplay(WeatherDisplay display) {
        displays.remove(display);
    }

    public void setWeather(double temperature, double humidity, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        notifyDisplays();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    private void notifyDisplays() {
        for (WeatherDisplay display : displays) {
            display.update();
        }
    }
}