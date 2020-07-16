package structure.strategy;

public class PekingDuck extends Duck {

	@Override
	public void display() {
		System.out.println("北京鸭");
	}
	
	/**
	 * 由于北京鸭不会飞翔，因此需要重写fly
	 */
	@Override
	public void fly(){
		System.out.println("北京鸭不会飞翔");
	}
	
}
