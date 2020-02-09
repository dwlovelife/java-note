package priciple.singleresponsibility;

public class SingleResponsibility3 {
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		Vehicle2 vehicle2 = new Vehicle2();
		vehicle2.run("汽车");
		vehicle2.runAir("飞机");
		vehicle2.runWater("轮船");
	}
}
//方式3的分析
//1. 这种修改方法没有对原来的类做重大的修改,只能增加方法
//2. 这里虽然没有在类这个级别上遵守单一职责原则,但是在方法级别上,依然是遵守单一原则
class Vehicle2 {
	
	public void run(String vehilce){
		System.out.println(vehilce + "在公路上运行....");
	}
	
	public void runAir(String vehicle){
		System.out.println(vehicle + "在天空中运行....");
	}
	
	public void runWater(String vehicle){
		System.out.println(vehicle + "在水中运行....");
	}
	
}
