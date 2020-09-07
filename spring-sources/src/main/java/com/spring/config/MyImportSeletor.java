package com.spring.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSeletor implements ImportSelector {

	// 返回值就是导入容器中的组件全类名
	// AnnotationMetadata:当前标注@Import注解的类的所有注解信息
	@Override
	public String[] selectImports(AnnotationMetadata annotationMetadata) {
		return new String[] { "com.spring.bean.Blue", "com.spring.bean.Yellow" };
	}

}
