package com.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring启动时 会自动扫描启动项所在根路径所有路径资源 和 ComponentScan指定向路径取最大集
 */
@SpringBootApplication
public class SourcesSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SourcesSpringBootApplication.class, args);
    }
}
