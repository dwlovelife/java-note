package establish.builder;


public abstract class AbstractHouse {

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    void build() {
        buildBasic();
        buildWalls();
        roofed();
    }

}
