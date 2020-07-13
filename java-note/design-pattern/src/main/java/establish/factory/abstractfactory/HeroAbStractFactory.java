package establish.factory.abstractfactory;

/**
 * 英雄抽象工厂 
 */
public abstract class HeroAbStractFactory implements MarketFactory {
	
	public abstract Hero getHero(String heroType);
	
}
