package structure.proxy.dynamicproxy;

public class TeacherDao implements ITeacherDao {

	@Override
	public void teach() {
		System.out.println("老师授课");
	}

}
