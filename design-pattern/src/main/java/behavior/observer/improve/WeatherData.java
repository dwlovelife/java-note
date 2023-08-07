package behavior.observer.improve;

import java.util.Observable;

/**
 * 天气数据
 */
public class WeatherData extends Observable {

    private WeatherDetail weatherDetail;

    public WeatherData() {}


    public void setMeasurements(WeatherDetail weatherDetail){
        this.weatherDetail = weatherDetail;
        this.setChanged();
        notifyObservers(weatherDetail);
    }

    public WeatherDetail getWeatherDetail() {
        return weatherDetail;
    }

    public void setWeatherDetail(WeatherDetail weatherDetail) {
        this.weatherDetail = weatherDetail;
    }

}
