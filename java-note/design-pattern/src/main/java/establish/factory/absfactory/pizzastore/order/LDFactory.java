package establish.factory.absfactory.pizzastore.order;

import establish.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import establish.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import establish.factory.absfactory.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory {

	public Pizza createPizza(String orderType) {
		System.out.println("使用的是抽象工厂模式LD");
		Pizza pizza = null;
		if(orderType.equals("cheese")){
			pizza = new BJCheesePizza();
		}else if(orderType.equals("pepper")){
			pizza = new BJPepperPizza(); 
		}
		return pizza;
	}
	
}
