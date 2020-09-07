package establish.factory.factorymethod;

/**
 * 法师工厂 
 */
public class MageFactory extends HeroFactory{

	@Override
	protected Hero productHero() {
		return new DaJi();
	}

}
