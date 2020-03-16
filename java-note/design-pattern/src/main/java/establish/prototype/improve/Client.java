package establish.prototype.improve;

/**
 * 
 * 如果羊多了一个属性,不会受创建方式的局限
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("原型模式完成对象的创建");
		Sheep sheep = new Sheep("tom", 1, "白色");
		Sheep shepp1 = sheep.clone();
		Sheep shepp2 = sheep.clone();
		Sheep shepp3 = sheep.clone();
		System.out.println("sheep1= + sheep");
		System.out.println("sheep2= + sheep");
		System.out.println("sheep3= + sheep");
	}
}
