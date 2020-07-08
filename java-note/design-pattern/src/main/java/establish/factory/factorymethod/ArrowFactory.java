package establish.factory.factorymethod;

/**
 * 定义一个射手英雄工厂 
 */
public class ArrowFactory extends HeroFactory{

	@Override
	protected Hero productHero() {
		return new HouYi();
	}

}
