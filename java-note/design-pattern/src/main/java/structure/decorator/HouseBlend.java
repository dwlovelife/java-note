package structure.decorator;

/**
 * 综合咖啡
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "综合咖啡";
    }

    @Override
    public Double cost() {
        return 23.2;
    }
}
