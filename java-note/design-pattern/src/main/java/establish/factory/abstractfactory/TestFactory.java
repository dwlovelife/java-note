package establish.factory.abstractfactory;

/**
 * 工厂测试 
 */
public class TestFactory {
	public static void main(String[] args) {
		System.out.println("----测试英雄工厂----");
		HeroFactory heroFactory = (HeroFactory) FactoryProduct.getFactoryByType("HeroFactory");
		Hero hero = heroFactory.getHero("ChengYaoJin");
		hero.haveHero();
		System.out.println("----测试皮肤工厂----");
		SkinFactory skinFactory = (SkinFactory) FactoryProduct.getFactoryByType("SkinFactory");
		Skin skin = skinFactory.getSkin("ChengYaoJin");
		skin.haveSkin();
	}
}
