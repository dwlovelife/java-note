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
    public double cost() {
        return beverage.cost() + 3.6;
    }
}
