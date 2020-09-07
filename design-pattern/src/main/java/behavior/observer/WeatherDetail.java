package behavior.observer;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherDetail {

    private double temperature; //当前温度
    private double humidity; //当前湿度
    private double pressure; //当前气压
    private List<WeatherDetail> forecastDetails;//未来几天的气象数据详情

}
