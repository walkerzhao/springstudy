package com.tencent.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * run: -Xms1024m -Xmx1024m -Xmn512m
 */
@SpringBootApplication
@RestController
@EnableAsync
//@EnableEurekaClient
@EnableFeignClients
public class ServerSpringApplication {


	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(ServerSpringApplication.class);
		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		if (!source.containsProperty("spring.profiles.active")
				&& !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
			// 如果未在命令行设置 --spring.profiles.active=dev 以及环境变量中没有
			// SPRING_PROFILES_ACTIVE
			app.setAdditionalProfiles("dev");// 默认使用开发环境
		}
		app.run(args);


		SpringApplication.run(ServerSpringApplication.class, args);
	}


	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplateBuilder().build();
		return restTemplate;
	}



}
