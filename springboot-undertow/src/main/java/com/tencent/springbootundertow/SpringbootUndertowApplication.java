package com.tencent.springbootundertow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootUndertowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUndertowApplication.class, args);
	}


	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		String result = "hi "+name+",i am from port:" +port;
		System.out.println(result);
		return result;
	}
}
