package establish.factory.simplefactory.pizzastore.order;

import establish.factory.simplefactory.pizzastore.pizza.CheesePizza;
import establish.factory.simplefactory.pizzastore.pizza.GreekPizza;
import establish.factory.simplefactory.pizzastore.pizza.PepperPizza;
import establish.factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * 
 * 使用简单工厂的目的是 如果有多个OrderPizza 那么每次增加一个Pizza
 * 所有的订购Pizza方法 都需要重新修改代码 将创建方法抛给工厂可以便于统一创建
 * 原传统方式 不满足OCP原则 即对扩展开放 对修改关闭 当然简单工厂可能也没那么好 
 * 但是！ 会稍微好点 代码都是一点点改进的
 */
//简单工厂类
public class SimpleFactory {
	
	//更改orderType 返回对应的Pizza对象
	public static Pizza createPizza(String orderType) {
		System.out.println("使用简单工厂模式");
		Pizza pizza = null;
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName("希腊Pizza");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName("奶酪Pizza");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("胡椒Pizza");
		}
		return pizza;
	}

}
