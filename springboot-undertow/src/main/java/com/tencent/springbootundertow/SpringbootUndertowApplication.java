package com.tencent.springbootundertow;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringbootUndertowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUndertowApplication.class, args);
	}

	//produces = "application/json;charset=UTF-8"

	@Value("${server.port}")
	String port;


	@RequestMapping(value = "/hi")
	public String home(@RequestParam String name) {
		String result = "hi "+name+",i am from port:" +port+"????";
		Map<Integer, String> map = new HashMap<>();
		map.put(1,"成功");
		String json = JSON.toJSONString(map);
		System.out.println(result + json);
		return json;
	}


	/**
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/himap", produces = "text/plain;charset=UTF-8")
	public String hiMap(@RequestParam String name) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1,"成功");

		String json = JSON.toJSONString(map);
		System.out.println(map + json);
		return json;
	}
}
