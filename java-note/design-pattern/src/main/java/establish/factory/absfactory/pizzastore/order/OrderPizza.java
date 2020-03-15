package establish.factory.absfactory.pizzastore.order;

import java.util.Scanner;

import establish.factory.absfactory.pizzastore.pizza.Pizza;

public class OrderPizza {

	AbsFactory factory;

	// 构造器
	public OrderPizza(AbsFactory factory) {
		setFactory(factory);
	}

	private void setFactory(AbsFactory factory) {
		Pizza pizza = null;
		String orderType = ""; // 用户输入
		this.factory = factory;
		do {
			orderType = getType();
			pizza = factory.createPizza(orderType);
			if (pizza != null) {
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			} else {
				System.out.println("订购失败");
				break;
			}
		} while (true);
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
