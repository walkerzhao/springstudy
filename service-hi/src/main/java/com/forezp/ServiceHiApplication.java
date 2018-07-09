package com.forezp;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
//@RestController
@Controller
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}

	@RequestMapping("/testRedirect")
	public String testRedirect(HttpServletRequest req, HttpServletResponse rsp) {
		Random random = new Random();
		int randInt = random.nextInt(21_0000_0000);
		String url = "redirect:" + "http://www.baidu.com"+ "/" + randInt;
		return url;
	}

}
