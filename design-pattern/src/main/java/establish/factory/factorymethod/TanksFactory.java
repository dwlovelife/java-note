package establish.factory.factorymethod;

/**
 * 坦克工厂 
 */
public class TanksFactory extends HeroFactory{

	@Override
	protected Hero productHero() {
		return new ChengYaoJin();
	}

}
