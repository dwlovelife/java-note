package establish.factory.factorymethod.pizzastore.order;

import java.util.Scanner;

import establish.factory.factorymethod.pizzastore.pizza.Pizza;

public abstract class OrderPizza {

	// 定义一个抽象方法,createPizza, 让各个工厂子类自己实现
	abstract Pizza createPizza(String orderType);

	public OrderPizza(){
		Pizza pizza = null;
		String orderType; //订购披萨的类型
		do {
			orderType = getType();
			pizza = createPizza(orderType); //抽象方法由工厂子类完成
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} while(true);
	}

	// 写一个方法 可以获取客户端订购的披萨种类
	private String getType() {
		String str = "";
		try {
			System.out.println("输入Pizza类型：");
			Scanner scanner = new Scanner(System.in);
			str = scanner.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

}
