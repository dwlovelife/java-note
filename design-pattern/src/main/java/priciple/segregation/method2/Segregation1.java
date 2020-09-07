package priciple.segregation.method2;

public class Segregation1 {
	public static void main(String[] args) {
		//接口隔离原则: 客户端不应该依赖它不需要的接口,即一个类对另一个类的依赖应该建立在最小接口上
		    
		
	}
}

//接口
interface Interface1 {
	
	void operation1();
	
}
interface Interface2 {
	
	void operation2();
	
	void operation3();
	
}
interface Interface3 {
	
	void operation4();
	
	void operation5();
	
}


class B implements Interface1,Interface2 {

	public void operation1() {
		System.out.println("B 实现了 operation1");
	}

	public void operation2() {
		System.out.println("B 实现了 operation2");
	}

	public void operation3() {
		System.out.println("B 实现了 operation3");
	}

	
}
class D implements Interface1,Interface3 {

	public void operation1() {
		System.out.println("D 实现了 operation1");
	}


	public void operation4() {
		System.out.println("D 实现了operation4");
	}

	public void operation5() {
		System.out.println("D 实现了operation5");
	}
	
}
class A { //A类 通过接口Interface1 依赖（使用）B类,但是只会到1,2,3方法
	
	public void depend1(Interface1 i){
		i.operation1();
	}
	
	public void depend2(Interface2 i){
		i.operation2();
	}
	
	public void depend3(Interface2 i){
		i.operation3();
	}
	
}
class C { //C 类通过接口Interface1 依赖（使用）D类，但是只会用到1,4,5
	
	public void depend1(Interface1 i){
		i.operation1();
	}
	
	public void depend4(Interface3 i){
		i.operation4();
	}
	
	public void depend5(Interface3 i){
		i.operation5();
	}
	
}

