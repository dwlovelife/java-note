package structure.strategy.improve;

public class PekingDuck extends Duck {

	@Override
	public void display() {
		System.out.println("北京鸭");
	}
	
	public  PekingDuck(){
		flyBehavior = new NormalFlyBehavior();
	}
}
