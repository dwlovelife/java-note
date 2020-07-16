package structure.decorator;




public class HouseBlend extends Beverage {
    public static void main(String[] args) {

    }
    public HouseBlend() {
        description = "综合咖啡";
    }

    @Override
    public double getCost() {
        return 23.2;
    }
}
