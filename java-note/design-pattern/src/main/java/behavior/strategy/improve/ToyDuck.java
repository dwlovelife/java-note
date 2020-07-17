package behavior.strategy.improve;

public class ToyDuck extends Duck {
	
	public ToyDuck(){
		flyBehavior = new NoFlyBehavior();
	}
	
	@Override
	public void display() {
		System.out.println("玩具鸭");
	}

	@Override
	public void quack() {
		System.out.println("玩具鸭不能叫~~~");
	}

	@Override
	public void fly() {
		System.out.println("玩具鸭不会飞翔~~");
	}

}
