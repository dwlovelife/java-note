package establish.singleton.type7;

public class SingletonTest07 {
	public static void main(String[] args) {
		Singleton singleton01 = Singleton.INSTANCE;
		Singleton singleton02 = Singleton.INSTANCE;
		System.out.println(singleton01 == singleton02);
	}
}
//枚举 天然单例
enum Singleton{
	INSTANCE;
}
