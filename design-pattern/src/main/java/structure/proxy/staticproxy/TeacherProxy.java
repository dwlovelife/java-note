package structure.proxy.staticproxy;

/**
 * 老师代理类
 */
public class TeacherProxy implements ITeacherDao{
	
	/**
	 * 被代理类
	 */
	ITeacherDao target;
	
	public TeacherProxy(ITeacherDao target){
		this.target = target;
	}
	
	/**
	 * 在代理类对象可以扩展被代理对象的原有的功能
	 */
	@Override
	public void teach() {
		System.out.println("--老师授课准备--");
		target.teach();
		System.out.println("--老师授课完毕");
	}
	
	
	
}
