package establish.factory.simplefactory;

/**
 * 测试方法 
 */
public class TestFactory {
	public static void main(String[] args) {
		HerosFactory herosFactory = new HerosFactory();
		Hero hero1 = herosFactory.getDifferentHero("DaJi");
		hero1.buyHeroSuccess();
		hero1.buySkinSuccess();
		System.out.println("-----------------");
		Hero hero2 = herosFactory.getDifferentHero("HouYi");
		hero2.buyHeroSuccess();
		hero2.buySkinSuccess();
	}
}
