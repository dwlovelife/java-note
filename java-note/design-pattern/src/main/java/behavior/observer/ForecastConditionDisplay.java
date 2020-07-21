package behavior.observer;


import java.util.List;

public class ForecastConditionDisplay implements Observer, DisplayElement {

    private List<WeatherDetail> forecastDetails;//未来几天的气象数据详情

    public ForecastConditionDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        if (!forecastDetails.isEmpty()) {
            for (WeatherDetail weatherDetail : forecastDetails) {
                System.out.println("forecast-[temperature:" + weatherDetail.getTemperature()
                        + ",humidity:" + weatherDetail.getHumidity() + ",pressure:" + weatherDetail.getPressure() + "]");
            }
        }
    }

    @Override
    public void update(WeatherDetail weatherDetail) {
        forecastDetails = weatherDetail.getForecastDetails();
    }
}
