package establish.factory.abstractfactory;

/**
 * 英雄工厂 
 */
public class HeroFactory extends HeroAbStractFactory {

	@Override
	public Hero getHero(String heroType) {
		if("HouYi".equals(heroType)){
			return new HouYiHero();
		}else if("DaJi".equals(heroType)){
			return new DaJiHero();
		}else if("ChengYaoJin".equals(heroType)){
			return new ChengYaoJinHero();
		}
		return null;
	}

}
