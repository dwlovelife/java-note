package structure.decorator;

/**
 * 创建一个饮料抽象类
 */
public abstract class Beverage {

    String description = "UnKnown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double getCost();

}
