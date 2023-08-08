package structure.decorator.example1;

import java.math.BigDecimal;

/**
 * 牛奶
 */
public class Soy extends Condiment {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription(){
        return beverage.getDescription() + "【豆浆】";
    }

    @Override
    public Double cost() {
        return new BigDecimal(beverage.cost().toString()).add(new BigDecimal(3.6)).doubleValue();
    }
}

