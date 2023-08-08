package structure.decorator.example1;


public class Client {
    public static void main(String[] args) {
        //一杯DarkRoast 不需要调料
        Beverage darkRoast = new DarkRoast();
        System.out.println(darkRoast.getDescription() + "，" + darkRoast.cost());

        //再点一个浓缩咖啡 加 双倍摩卡 一份奶泡
        Beverage beverage = new Expresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription() + "，" + beverage.cost());
    }
}
