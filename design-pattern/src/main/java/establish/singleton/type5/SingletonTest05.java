package establish.singleton.type5;

public class SingletonTest05 {
	public static void main(String[] args) {
		System.out.println("线程安全版的单例模式，采用双重检索");
		Singleton singleton01 = Singleton.getInstance();
		Singleton singleton02 = Singleton.getInstance();
		System.out.println(singleton01 == singleton02);
	}
}
//双重检索版的单例模式
class Singleton {
	
	private static volatile Singleton instance;
	
	private Singleton(){}
	
	//提取一个静态的公有办法，加入双重检查机制，解决线程安全问题，同时解决懒加载问题
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
}
