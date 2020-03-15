package establish.factory.factorymethod.pizzastore.pizza;

public class LDCheesePizza extends Pizza {

	@Override
	public void prepare() {
		setName("伦敦的奶酪pizza");
		System.out.println(" 伦敦的奶酪pizza准备原材料 ");
	}
	
	
}

