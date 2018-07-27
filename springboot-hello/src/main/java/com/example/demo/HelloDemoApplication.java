package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAsync
public class HelloDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloDemoApplication.class, args);
		System.out.println("hello,world");
	}


	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String sayHi(@RequestParam String name) {
		String result = "hi "+name+",i am from port:" +port;
		System.out.println(result);
		return result;
	}
}
