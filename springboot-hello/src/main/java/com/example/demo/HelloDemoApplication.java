package com.example.demo;

import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableAsync
public class HelloDemoApplication {

	@Autowired
	BookService bookService;

	public static void main(String[] args) {

		SpringApplication.run(HelloDemoApplication.class, args);

	}


	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String sayHi(@RequestParam String name) {
		String result = "hi "+name+",i am from port:" +port;
		System.out.println(result);
		bookService.bookFlight();
		return result;
	}

	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplateBuilder() //
				.setConnectTimeout(1 * 1000) // 1s
				.setReadTimeout(3 * 1000) //  3s
				.build();
	}
}
