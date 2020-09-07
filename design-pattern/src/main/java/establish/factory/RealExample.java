package establish.factory;

import java.util.Calendar;

/**
 * 
 * JDK源码里的真实案例
 */
public class RealExample {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println("年:" + cal.get(Calendar.YEAR));
		System.out.println("月:" + (cal.get(Calendar.MONTH) + 1));
	}
}
