package behavior.observer.improve;


import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ForecastConditionDisplay implements Observer, DisplayElement {

    private List<WeatherDetail> forecastDetails;//未来几天的气象数据详情

    public ForecastConditionDisplay(Observable weatherData) {
        //天气数据
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        if (forecastDetails != null) {
            for (WeatherDetail weatherDetail : forecastDetails) {
                System.out.println("forecast-[temperature:" + weatherDetail.getTemperature()
                        + ",humidity" + weatherDetail.getHumidity() + ",pressure" + weatherDetail.getPressure() + "]");
            }
        }
    }

    @Override
    public void update(Observable observable, Object arg) {
        WeatherDetail weatherDetail = (WeatherDetail) arg;
        this.forecastDetails = weatherDetail.getForecastDetails();
    }

}
