package establish.factory.abstractfactory;

/**
 * 皮肤工厂
 */
public class SkinFactory extends SkinAbStractFactory {

	@Override
	public Skin getSkin(String skinType) {
		if("HouYi".equals(skinType)){
			return new HouYiSkin();
		}else if("DaJi".equals(skinType)){
			return new DaJiSkin();
		}else if("ChengYaoJin".equals(skinType)){
			return new ChengYaoJinSkin();
		}
		return null;
	}

}
