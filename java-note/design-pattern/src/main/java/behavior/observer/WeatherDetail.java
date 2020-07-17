package behavior.observer;


import java.util.List;

public class WeatherDetail {

    private double temperature; //当前温度
    private double humidity; //当前湿度
    private double pressure; //当前气压
    private List<WeatherDetail> forecastDetails;//未来几天的气象数据详情

    public WeatherDetail(double temperature, double humidity, double pressure, List<WeatherDetail> forecastDetails) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastDetails = forecastDetails;
    }

    public WeatherDetail(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public List<WeatherDetail> getForecastDetails() {
        return forecastDetails;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setForecastDetails(List<WeatherDetail> forecastDetails) {
        this.forecastDetails = forecastDetails;
    }
}
