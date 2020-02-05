package establish.singleton.type1;

public class SingletonTest01 {
	public static void main(String[] args) {
		//测试
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		//并且由于私有化构造器 你无法通过new 创建对象实例
		System.out.println(singleton1 == singleton2);
	}
}

// 饿汉式(静态变量)
class Singleton {

	//本类内部创建对象实例
	private static final Singleton _INSTANCE = new Singleton();
	
	// 构造器私有化
	private Singleton() {}
	
	//提供一个公有的静态方法
	public static Singleton getInstance(){
		return _INSTANCE;
	}

}