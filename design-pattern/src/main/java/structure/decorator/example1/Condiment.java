package structure.decorator.example1;

/**
 * 调料抽象类
 */
public abstract class Condiment extends Beverage {

    Beverage beverage;

    Condiment(Beverage decoratedBeverage){
        this.beverage = decoratedBeverage;
    }

    public abstract String getDescription();

}
