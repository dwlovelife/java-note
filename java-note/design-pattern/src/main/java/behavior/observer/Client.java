package behavior.observer;


import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<WeatherDetail> forecastDetail = new ArrayList<>();
        forecastDetail.add(new WeatherDetail(23.0, 0.9, 1.1));
        forecastDetail.add(new WeatherDetail(17.0, 0.5, 1.3));
        WeatherDetail weatherDetail = new WeatherDetail(22.0, 0.8, 1.2, forecastDetail);
        WeatherData weatherData = new WeatherData();
        DisplayElement current = new CurrentConditionDisplay(weatherData);
        DisplayElement forecast = new ForecastConditionDisplay(weatherData);
        weatherData.setMeasurements(weatherDetail);

        current.display();
        forecast.display();
    }
}
