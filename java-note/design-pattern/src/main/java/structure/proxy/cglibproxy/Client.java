package structure.proxy.cglibproxy;

public class Client {
	public static void main(String[] args) {
		TeacherDao teacherDao = new TeacherDao();
		TeacherDao proxy = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
		System.out.println(proxy.getClass());
		proxy.teach();
	}
}
