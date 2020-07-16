package structure.decorator;

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
    public double getCost() {
        return beverage.getCost() + 2.2;
    }
}
