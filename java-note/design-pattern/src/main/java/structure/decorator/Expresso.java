package structure.decorator;

/**
 * 浓缩咖啡
 */
public class Expresso extends Beverage{

    public Expresso(){
        description = "浓缩咖啡";
    }

    @Override
    public Double cost() {
        return 19.9;
    }
}

