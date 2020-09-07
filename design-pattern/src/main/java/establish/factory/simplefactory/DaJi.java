package establish.factory.simplefactory;

/**
 * 英雄妲己
 */
public class DaJi implements Hero {

	@Override
	public void buyHeroSuccess() {
		System.out.println("勇士,恭喜你获得了英雄-妲己！");
	}

	@Override
	public void buySkinSuccess() {
		System.out.println("恭喜你获得了皮肤-热情桑巴");
	}

}
