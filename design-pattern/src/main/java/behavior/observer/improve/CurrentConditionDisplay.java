package behavior.observer.improve;

import java.util.Observable;
import java.util.Observer;

/**
 * 当前展板
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private double temperature; //当前温度
    private double humidity; //当前湿度
    private double pressure; //当前气压

    public CurrentConditionDisplay(Observable weatherData) {
        //天气数据
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("current-[temperature:" + temperature + ",humidity:" + humidity + ",pressure:" + pressure + "]");
    }


    @Override
    public void update(Observable observable, Object arg) {
        WeatherDetail weatherDetail = (WeatherDetail) arg;
        this.temperature = weatherDetail.getTemperature();
        this.humidity = weatherDetail.getHumidity();
        this.pressure = weatherDetail.getPressure();
    }
}
