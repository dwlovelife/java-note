package establish.builder.improve;

/**
 * 抽象的建造者
 */
public abstract class HouseBuilder {

    private House house = new House();

    /**
     * 将建造的流程写好,抽象的方法
     */
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造房子
    House buildHouse(){
        return house;
    }

}
