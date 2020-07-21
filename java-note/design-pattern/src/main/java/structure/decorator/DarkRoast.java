package structure.decorator;


public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "黑莓咖啡";
    }

    @Override
    public Double cost() {
        return 21.8;
    }

}
