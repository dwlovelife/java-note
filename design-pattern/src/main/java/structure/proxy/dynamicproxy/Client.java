package structure.proxy.dynamicproxy;

public class Client {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		ITeacherDao teacherDao = new TeacherDao();
		System.out.println(teacherDao.getClass().getInterfaces());
		ITeacherDao proxy = (ITeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
		System.out.println(proxy.getClass());
		proxy.teach();
	}
}
