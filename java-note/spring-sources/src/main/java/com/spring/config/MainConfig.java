package com.spring.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.spring.bean.Color;
import com.spring.bean.ColorFactoryBean;
import com.spring.bean.Person;
import com.spring.bean.Red;
import com.spring.bean.White;
import com.spring.condition.LinuxCondition;
import com.spring.condition.WindowsCondition;

@Configuration
@ComponentScan(value = "com.spring")
@Import({ Color.class, Red.class, MyImportSeletor.class, MyImportBeanDefintionRegister.class })
public class MainConfig {

	/**
	 * prototype: 多实例的 singleton: 单实例的（默认值），ioc容器启动会调用方法创建对象,以后每次获取从容器中拿
	 * request: 同一次请求创建一个实例 session: 同一个session创建一个实例
	 * 
	 * 懒加载: 单实例bean: 默认容器启动的时候创建对象 懒加载：容器启动不创建对象。第一次使用（获取）Bean创建对象,并初始化
	 */
	@Bean
	@Lazy
	public Person person() {
		System.out.println("给容器中添加person");
		return new Person("ZhangSan", 20);
	}

	@Conditional({ WindowsCondition.class })
	@Bean("bill")
	public Person person01() {
		return new Person("Bill Gates", 62);
	}

	@Conditional({ LinuxCondition.class })
	@Bean("linus")
	public Person person02() {
		return new Person("linus", 62);
	}
	
	
	@Bean
	public FactoryBean<White> factoryBean(){
		return new ColorFactoryBean();
	}

	/**
	 * 给容器中注册组件 
	 * 1)、包扫描 + 组件标注注解 (@Controller、@Service、@Repository、@Component)
	 * 2)、@Bean[导入的第三方包里面的组件] 
	 * 3)、@Import[快速给容器中导入一个组件]
	 * 		1- @Import(要导入到容器中的组件):容器中会自动注册到这个组件,id默认是全类名 
	 * 		2- ImportSeletor:返回需要导入组件的全类名数组
	 * 		3- ImportBeanDefinitionRegistrar: 手工注册bean到容器中
	 * 4)、使用Spring提供的FactoryBean(工厂Bean)
	 * 		1- 默认获取到的是工厂bean调用getObject创建的对象
	 * 		2- 获取工厂bean本身.我们需要给id前面加一个& （&colorFactoryBean）
	 */

}
