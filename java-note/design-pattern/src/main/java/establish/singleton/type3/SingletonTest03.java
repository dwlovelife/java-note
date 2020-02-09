package establish.singleton.type3;

public class SingletonTest03 {
	public static void main(String[] args) {
		System.out.println("懒汉式，线程不安全的");
		Singleton instance01 = Singleton.getInstance();
		Singleton instance02 = Singleton.getInstance();
		System.out.println(instance01 == instance02);
	}
}
//懒汉式-线程不安全
class Singleton {
	
	private static Singleton instance;
	
	private Singleton(){}
	
	//提供一个静态的公有办法，当使用到该方法时，才去创建instance
	//即懒汉式
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	
}
