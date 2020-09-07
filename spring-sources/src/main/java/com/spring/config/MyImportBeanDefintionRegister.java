package com.spring.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.spring.bean.Black;

public class MyImportBeanDefintionRegister implements ImportBeanDefinitionRegistrar {
	
	/**
	 *  AnnotationMetadata: 当前类的注解信息
	 *  BeanDefintionRegistry:BeanDefintion注册类
	 *  	把所有需要添加到容器的Bean：调用BeanDefintionRegistry.registerBeanDefinitions
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		boolean isContainBlue = registry.containsBeanDefinition("com.spring.bean.Blue");
		boolean isContainRed = registry.containsBeanDefinition("com.spring.bean.Red");
		if(isContainBlue && isContainRed){
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Black.class);
			registry.registerBeanDefinition("black", beanDefinition);
		}
	}

}
