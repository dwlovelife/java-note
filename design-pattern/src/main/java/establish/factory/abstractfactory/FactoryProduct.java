package establish.factory.abstractfactory;

/**
 * 工厂（商城） 
 */
public class FactoryProduct {
	
	public static MarketFactory getFactoryByType(String factoryType){
		if("HeroFactory".equals(factoryType)){
			return new HeroFactory();
		}else if("SkinFactory".equals(factoryType)){
			return new SkinFactory();
		}
		return null;
	}
	
}
