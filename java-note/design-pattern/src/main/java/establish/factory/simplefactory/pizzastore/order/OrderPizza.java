package establish.factory.simplefactory.pizzastore.order;

import java.util.Scanner;

import establish.factory.simplefactory.pizzastore.pizza.Pizza;

public class OrderPizza {

	public OrderPizza() {
		setFatcory();
	}

	public void setFatcory() {
		do {
			Pizza pizza = SimpleFactory.createPizza(getType());
			if (pizza == null) {
				System.out.println("订购披萨失败");
				break;
			}
			// 输出pizza 制作过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
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
