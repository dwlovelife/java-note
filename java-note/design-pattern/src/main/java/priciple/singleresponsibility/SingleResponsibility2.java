package priciple.singleresponsibility;

public class SingleResponsibility2 {
	public static void main(String[] args) {
		
	}
}
class RoadVehicle {
	public void run(String vehilce){
		RoadVehicle roadVehilce = new RoadVehicle();
		roadVehilce.run("摩托车");
		roadVehilce.run("汽车");
		
		AirVehicle airVehicle = new AirVehicle();
		airVehicle.run("飞机");
	}
}
//方案2的分析
//1. 遵守单一职责原则
//2. 但是这样做改动很大,即不仅需要将类分解,与此同时还需要修改客户端
//3. 改进: 直接修改Vehicle 类,改动的代码会比较少 => 方案3
class AirVehicle {
	public void run(String vehilce){
		System.out.println(vehilce + "天空运行");
	}
}

class WaterVehilce {
	public void run(String vehicle){
		System.out.println(vehicle + "水中运行");
	}
}