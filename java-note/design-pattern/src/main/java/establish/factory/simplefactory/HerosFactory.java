package establish.factory.simplefactory;

/**
 * 王者荣耀工厂（商城）
 */
public class HerosFactory {
	
	/**
	 * 根据不同的标签生产不同的英雄
	 */
	public Hero getDifferentHero(String heroType) {
		if("HouYi".equals(heroType)){
			return new HouYi();
		}else if("DaJi".equals(heroType)){
			return new DaJi();
		}else if("ChengYaoJin".equals(heroType)){
			return new ChengYaoJin();
		}
		return null;
	}

}
