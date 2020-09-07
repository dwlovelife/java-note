package structure.proxy.staticproxy;

public class Client {
	public static void main(String[] args) {
		//被代理类
		ITeacherDao target = new TeacherDao();
		//代理对象
		TeacherProxy teacherProxy = new TeacherProxy(target);
		teacherProxy.teach();
	}
}
