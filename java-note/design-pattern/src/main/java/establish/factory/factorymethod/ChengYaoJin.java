package establish.factory.factorymethod;

/**
 * 程咬金 
 */
public class ChengYaoJin implements Hero {

	@Override
	public void buyHeroSuccess() {
		System.out.println("勇士,恭喜你获得了英雄-程咬金！");
	}

	@Override
	public void buySkinSuccess() {
		System.out.println("恭喜你获得了皮肤-爱与正义");
	}

}
