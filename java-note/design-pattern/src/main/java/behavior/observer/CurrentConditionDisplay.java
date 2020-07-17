package behavior.observer;

/**
 * 当前展板
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private double temperature; //当前温度
    private double humidity; //当前湿度
    private double pressure; //当前气压

    public CurrentConditionDisplay(Subject weatherData) {
        //天气数据
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("current-[temperature:" + temperature + ",humidity:" + humidity + ",pressure:" + pressure + "]");
    }

    @Override
    public void update(WeatherDetail weatherDetail) {
        this.temperature = weatherDetail.getTemperature();
        this.humidity = weatherDetail.getHumidity();
        this.pressure = weatherDetail.getPressure();
    }
}
