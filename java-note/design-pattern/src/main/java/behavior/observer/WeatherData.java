package behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气数据
 */
public class WeatherData implements Subject {

    private List<Observer> observers;
    private WeatherDetail weatherDetail;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!observers.isEmpty()) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(weatherDetail);
        }
    }

    public void setMeasurements(WeatherDetail weatherDetail){
        this.weatherDetail = weatherDetail;
        notifyObserver();
    }

}
