package structure.decorator;

import java.math.BigDecimal;

/**
 *  奶泡
 */
public class Whip extends Condiment {

    public Whip(Beverage beverage){
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "【奶泡】";
    }

    @Override
    public Double cost() {
        return new BigDecimal(beverage.cost().toString()).add(new BigDecimal(2.7)).doubleValue();
    }
}
