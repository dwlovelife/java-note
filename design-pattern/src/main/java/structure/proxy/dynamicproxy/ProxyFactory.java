package structure.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
public class ProxyFactory {
	
	//被代理对象
	Object target;
	
	public ProxyFactory(Object target){
		this.target = target;
	}
	
	public Object getProxyInstance(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("--老师授课前--");
				Object returnVal = method.invoke(target, args);
				System.out.println("--老师授课后--");
				return returnVal;
			}
		});
	}
	
}
