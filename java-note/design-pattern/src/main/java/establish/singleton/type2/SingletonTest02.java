package establish.singleton.type2;

public class SingletonTest02 {
	public static void main(String[] args) {
		Singleton singleton01 = Singleton.getInstance();
		Singleton singleton02 = Singleton.getInstance();
		System.out.println(singleton01 == singleton02);
	}
}

//饿汉式（静态代码块）
class Singleton {
	// 将单例模式的创建放在静态代码块中，与第一种基本相同
	private static Singleton instance;

	static {
		instance = new Singleton();
	}

	// 私有化构造器
	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

}
