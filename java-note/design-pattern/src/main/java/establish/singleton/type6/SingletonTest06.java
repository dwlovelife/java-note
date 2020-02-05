package establish.singleton.type6;

public class SingletonTest06 {
	public static void main(String[] args) {
		System.out.println("内部类版本的单例模式，利用静态内部类完成延迟加载,并且是线程安全的");
		Singleton singleton01 = Singleton.getInstance();
		Singleton singleton02 = Singleton.getInstance();
		System.out.println(singleton01 == singleton02);
	}
}
class Singleton{
	
	//构造器私有化
	private Singleton(){}
	
	//写一个静态内部类,该类中有一个静态属性 Singleton
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	
	//提供一个静态的公有办法,直接返回Singleton.instance
	public static synchronized Singleton getInstance(){
		return SingletonInstance.INSTANCE;
	}
	
}
