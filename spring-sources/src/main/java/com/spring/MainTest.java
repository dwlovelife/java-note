package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.bean.Person;
import com.spring.config.MainConfig;

public class MainTest {
	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//		Person person = (Person) applicationContext.getBean("person");
//		System.out.println(person);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
	}
}
