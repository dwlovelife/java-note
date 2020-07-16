package structure.decorator;

/**
 * 牛奶
 */
public class Soy extends Condiment {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "【豆浆】";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 3.6;
    }
}
