package establish.factory.simplefactory;

/**
 * 英雄后羿
 */
public class HouYi implements Hero {

	@Override
	public void buyHeroSuccess() {
		System.out.println("勇士,恭喜你获得了英雄-后羿！");
	}

	@Override
	public void buySkinSuccess() {
		System.out.println("恭喜你获得了皮肤-黄金射手座");
	}

}
