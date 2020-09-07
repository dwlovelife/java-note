package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<White> {

	@Override
	public White getObject() throws Exception {
		return new White();
	}

	@Override
	public Class<?> getObjectType() {
		return White.class;
	}

}
