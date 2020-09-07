package structure.proxy.cglibproxy;

/**
 * 对于cglib代理,被代理对象无需实现接口 
 */
public class TeacherDao {
	
	public void teach(){
		System.out.println("老师授课");
	}
	
}
