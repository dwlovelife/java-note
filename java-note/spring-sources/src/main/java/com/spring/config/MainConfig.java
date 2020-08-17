package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.spring.bean.Person;
import com.spring.condition.LinuxCondition;
import com.spring.condition.WindowsCondition;

@Configuration
@ComponentScan(value = "com.spring")
public class MainConfig {
	
	/**
	 * prototype: 多实例的
	 * singleton: 单实例的（默认值），ioc容器启动会调用方法创建对象,以后每次获取从容器中拿
	 * request: 同一次请求创建一个实例
	 * session: 同一个session创建一个实例
	 * 
	 * 懒加载:
	 * 		单实例bean: 默认容器启动的时候创建对象
	 * 		懒加载：容器启动不创建对象。第一次使用（获取）Bean创建对象,并初始化
	 */
	@Bean
	@Lazy
	public Person person(){
		System.out.println("给容器中添加person");
		return new Person("ZhangSan",20);
	}
	
	@Conditional({WindowsCondition.class})
	@Bean("bill")
	public Person person01(){
		return new Person("Bill Gates",62);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02(){
		return new Person("linus",62);
	}
	
	/**
	 * 给容器中注册组件
	 * 1)、包扫描 + 组件标注注解 (@Controller、@Service、@Repository、@Component)
	 * 2)、@Bean[导入的第三方包里面的组件]
	 * 3)、@Import[快速给容器中导入一个组件]
	 */
	
}
