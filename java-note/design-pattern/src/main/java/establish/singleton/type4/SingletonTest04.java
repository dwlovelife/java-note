package establish.singleton.type4;

public class SingletonTest04 {
	public static void main(String[] args) {
		System.out.println("使用同步代码块的线程安全的单例模式");
		Singleton singleton01 = Singleton.getInstance();
		Singleton singleton02 = Singleton.getInstance();
		System.out.println(singleton01 == singleton02);
	}
}
//懒汉式-线程安全
class Singleton {
	
	private static Singleton instance;
	
	//私有化构造器
	private Singleton(){}
	
	//加入同步代码块。解决线程安全问题
	public static synchronized Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
}
