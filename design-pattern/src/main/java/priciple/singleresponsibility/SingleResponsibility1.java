package priciple.singleresponsibility;

public class SingleResponsibility1 {
	public static void main(String[] args) {
		//TODO Auto-generate method stub
		Vehicle vehicle = new Vehicle();
		vehicle.run("摩托车");
		vehicle.run("汽车");
		vehicle.run("飞机");
	}
}
//交通工具类
//方式1的分析
//1. 在方式1的run方法中，违反里单一职责原则
//2. 解决的方法非常简单,根据交通工具运行的方法不同，分解成不同的类型
class Vehicle {
	public void run(String vehicle){
		System.out.println(vehicle + "在公路上运行");
	}
}
