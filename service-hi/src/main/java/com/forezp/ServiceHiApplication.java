package com.forezp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@SpringBootApplication(scanBasePackages={"com.forezp"})
//@EnableEurekaClient
//@RestController
@EnableDiscoveryClient
@EnableFeignClients
//@Controller
public class ServiceHiApplication {

//	@Override
//	public final ServiceStageProcessor newProcessor() {
//		ServiceStageProcessor processor = create();    beanFactory.autowireBeanProperties(processor,AutowireCapableBeanFactory.AUTOWIR_NO, false);
//
//		beanFactory.initializeBean(processor,
//				processor.getClass().getSimpleName() + "@" + Integer.toHexString(processor.hashCode())); // this call causes the memory leak
//		return processor;
//	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ServiceHiApplication.class);
		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		if (!source.containsProperty("spring.profiles.active")
				&& !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
			// 如果未在命令行设置 --spring.profiles.active=dev 以及环境变量中没有
			// SPRING_PROFILES_ACTIVE
			app.setAdditionalProfiles("dev");// 默认使用开发环境
		}
		app.run(args);


//		SpringApplication.run(ServiceHiApplication.class, args);
	}

//	@Value("${server.port}")
//	String port;
//	@RequestMapping("/hi")
//	public String home(@RequestParam String name) {
//		return "hi "+name+",i am from port:" +port;
//	}
//
//	@RequestMapping("/testRedirect")
//	public String testRedirect(HttpServletRequest req, HttpServletResponse rsp) {
//		Random random = new Random();
//		int randInt = random.nextInt(21_0000_0000);
//		String url = "redirect:" + "http://www.baidu.com"+ "/" + randInt;
//		return url;
//	}

}
