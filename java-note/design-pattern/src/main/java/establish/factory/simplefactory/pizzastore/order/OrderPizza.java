package establish.factory.simplefactory.pizzastore.order;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import establish.factory.simplefactory.pizzastore.pizza.CheesePizza;
import establish.factory.simplefactory.pizzastore.pizza.GreekPizza;
import establish.factory.simplefactory.pizzastore.pizza.PepperPizza;
import establish.factory.simplefactory.pizzastore.pizza.Pizza;

public class OrderPizza {
	
	//构造器
	public OrderPizza(){
		Pizza pizza = null;
		String orderType; //订购Pizza的类型
		do {
			orderType = getType();
			if(orderType.equals("greek")){
				pizza = new GreekPizza();
				pizza.setName("希腊Pizza");
			} else if(orderType.equals("cheese")){
				pizza = new CheesePizza();
				pizza.setName("奶酪Pizza");
			} else if(orderType.equals("pepper")){
				pizza = new PepperPizza();
				pizza.setName("胡椒Pizza");
			} else {
				break;
			}
			//输出pizza 制作过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} while(true);
	}
	
	//写一个方法 可以获取客户端订购的披萨种类
	private String getType(){
		String str = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza type");
			str = bufferedReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
}
