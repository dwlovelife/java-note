package structure.decorator.example1;

import java.math.BigDecimal;

/**
 * 摩卡
 */
public class Mocha extends Condiment {


    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "【摩卡】";
    }

    @Override
    public Double cost() {
        return new BigDecimal(beverage.cost().toString()).add(new BigDecimal(2.2)).doubleValue();
    }
}
