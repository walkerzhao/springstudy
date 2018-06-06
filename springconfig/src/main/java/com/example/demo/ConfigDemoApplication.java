package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration("classpath=*application.yaml")
@SpringBootApplication
public class ConfigDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ConfigDemoApplication.class, args);
		Environment env = context.getEnvironment();
		//打断点,查看env中的 上下文
		System.out.println(env.getProperty("server.port"));
	}
}
