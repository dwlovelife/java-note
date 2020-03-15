package establish.factory.factorymethod.pizzastore.order;

import establish.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import establish.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import establish.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {

	@Override
	Pizza createPizza(String orderType) {
		Pizza pizza = null;
		if(orderType.equals("cheese")){
			pizza = new BJCheesePizza();
		}else if(orderType.equals("pepper")){
			pizza = new BJPepperPizza();
		}
		return pizza;
	}

}
