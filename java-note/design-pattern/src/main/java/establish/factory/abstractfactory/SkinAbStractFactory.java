package establish.factory.abstractfactory;

/**
 * 皮肤抽象工厂
 */
public abstract class SkinAbStractFactory implements MarketFactory {

	public abstract Skin getSkin(String skinType);

}
