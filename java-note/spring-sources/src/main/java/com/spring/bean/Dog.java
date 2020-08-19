package com.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog(){
		System.out.println("-------dog constructor-----");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("-------dog postConstruct-------");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("-------dog destroy--------");
	}
	
}
