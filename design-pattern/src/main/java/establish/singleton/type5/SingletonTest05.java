package establish.singleton.type5;

import lombok.Synchronized;

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
	
	private static volatile Singleton singleton;

	private Singleton(){}

	public static Singleton getInstance(){
		if(singleton == null){
			synchronized(Singleton.class){
				if(singleton == null){
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
}
