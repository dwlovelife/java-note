package com.springtest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.Car;
import com.spring.bean.White;
import com.spring.config.MainConfig;

public class IOCTest {

	@Test
	public void test1() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
	}
	
	@Test
	public void test3(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Object white =  applicationContext.getBean("factoryBean");
		Object factory =  applicationContext.getBean("&factoryBean");
		System.out.println(factory.getClass());
		System.out.println(white.getClass());
	}
	
	@Test
	public void test4(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("容器创建");
		Object car =  applicationContext.getBean(Car.class);
		System.out.println(car.getClass());
		applicationContext.close();
	}

	@Test
	public void test2() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("容器创建成功");
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);
	}

}
