package establish.prototype;

/**
 * 克隆羊
 * 1.优点是比较好理解,简单易操作
 * 2.在创建新的对象时,总是需要重新获取原始对象的属性,如果创建的对象比较复杂时,效率较低
 * 3.总是需要重新初始化对象,而不是动态地获得对象运行时的状态,不够灵活
 * 
 */
public class Client {
	public static void main(String[] args) {
		// 传统的方法
		Sheep sheep = new Sheep("tom", 1, "白色");

		Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
		Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
		Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
		System.out.println(sheep1);
		System.out.println(sheep2);
		System.out.println(sheep3);
		
	}
}
