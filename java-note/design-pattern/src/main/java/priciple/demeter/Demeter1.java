package priciple.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则
 * 基本介绍
 * 1.一个对象应该对其他对象保持最少的了解
 * 2.类与类关系越密切，耦合度越大
 * 3.迪米特法则又叫最少知道原则,即一个类对自己依赖的类知道的越少越好。也就是说，对于其他被依赖的类不管多么复杂,
 *   都尽量将逻辑封装在类的内部。对除了提供的public方法,不对外泄漏任何消息
 * 4.迪米特法则还有个更简单的定义;只与直接的朋友通信
 * 5.直接的朋友：每个对象都会与其他对象有耦合关系，只要两个对象之间有耦合关系，我们就说这两个对象之间是朋友关系，耦合的方式很多
 *   依赖,关联,组合,聚合等。其中我们称出现成员变量,方法参数,方法返回值中的类为直接朋友
 * 
 */
public class Demeter1 {
	public static void main(String[] args) {
		//创建了一个SchoolManager
		SchoolManager schoolManager = new SchoolManager();
		schoolManager.printAllEmployee(new CollegeManager());
	}
}

// 学校总部员工类
class Employee {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

// 学院员工类
class CollegeEmployee {
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}

// 管理学院员工的类
class CollegeManager {
	// 返回学院的所有员工
	public List<CollegeEmployee> getAllEmployee() {
		List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
		for (int i = 0; i < 10; i++) {
			CollegeEmployee emp = new CollegeEmployee();
			emp.setId("学院员工Id:" + i);
			list.add(emp);
		}
		return list;
	}
}

// 学校的管理类
class SchoolManager {
	// 返回学校总部的员工
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		
		for (int i = 0; i < 5; i++) { //这里我们增加五个员工到list中去
			Employee emp = new Employee();
			emp.setId("学校总部员工id=" + i);
			list.add(emp);
		}
		return list;
	}

	// 打印所有的员工 信息
	void printAllEmployee(CollegeManager sub) {
		List<CollegeEmployee> list1 = sub.getAllEmployee();
		System.out.println("-------分公司员工----------");
		for (CollegeEmployee e : list1) {
			System.out.println(e.getId());
		}
		List<Employee> list2 = this.getAllEmployee();
		System.out.println("-------学校总部员工--------");
		for(Employee e:list2){
			System.out.println(e.getId());
		}
	}
}
