package establish.factory.simplefactory.pizzastore.order;

//相当于一个客户端,发出订购
public class PizzaStore {
	public static void main(String[] args) {
		new OrderPizza();
		System.out.println("------退出程序--------");
	}
}
