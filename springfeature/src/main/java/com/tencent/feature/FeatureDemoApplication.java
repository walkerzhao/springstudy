package com.tencent.feature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

//@Configuration("classpath=*application.yaml")
@SpringBootApplication
@RestController
@EnableAsync
public class FeatureDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FeatureDemoApplication.class, args);
		Environment env = context.getEnvironment();
		//打断点,查看env中的 上下文
		System.out.println(env.getProperty("server.port"));
	}
}
