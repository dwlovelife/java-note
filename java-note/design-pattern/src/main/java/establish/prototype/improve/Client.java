package establish.prototype.improve;


public class Client {
	public static void main(String[] args) {
		// 牡丹花
		Flower peony = new Flower("牡丹", "blue");
		// 牡丹园
		Garden peonyGarden = new Garden(1000, peony);
		System.out.println("初始的牡丹园:" + peonyGarden);
		// 牡丹园的复制建造 但是花改成玫瑰 改名玫瑰园
		Garden roseGarden = peonyGarden.clone();
		//浅复制只会复制引用地址，并没有重新复制一个对象
		System.out.println(peonyGarden.getFlower() == roseGarden.getFlower());
		// 改为种植玫瑰花
		roseGarden.getFlower().setName("玫瑰");
		roseGarden.getFlower().setColor("red");
		System.out.println("玫瑰园：" + roseGarden);
		System.out.println("牡丹园：" + peonyGarden);
	}
}
