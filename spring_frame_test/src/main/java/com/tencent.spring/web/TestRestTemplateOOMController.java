package com.tencent.spring.web;


import com.tencent.spring.dao.LgnDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *  restTemplate请求问题
 * @link https://github.com/spring-cloud/spring-cloud-netflix/issues/947
 *
 * @author zhaoyu
 * @date 2018-11-09
 */
@RestController
public class TestRestTemplateOOMController {

	private static final Logger log = LoggerFactory.getLogger(TestRestTemplateOOMController.class);

	@Autowired
	private LgnDao lgnDao;

	@Autowired
	private RestTemplate restTemplate;

	String url = "https://www.baidu.com";

	/**
	 * @param
	 * @return
	 */
	@RequestMapping( value = "testRestTemplate1")
		 public String testRestTemplate1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Random random = new Random();
		int data = random.nextInt(21_0000_0000);
		String url1 = url + "?order=" + data;
		log.info("url1:{}", url1);
		ResponseEntity<String> result = restTemplate.getForEntity(url1, String.class);
		System.out.println(result);
		return "suc";
	}

	@RequestMapping( value = "testRestTemplate2")
		 public String testRestTemplate2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Random random = new Random();
		int data = random.nextInt(21_0000_0000);
		String url2 = url + "?order={order}";
		Map<String, Object> param = new HashMap<>();
		param.put("order", data);
		log.info("url2:{}", url2);
		ResponseEntity<String> result = restTemplate.getForEntity(url2, String.class, param);
		System.out.println(result);
		return "suc";
	}


	@RequestMapping( value = "testParam")
	public String testParam(HttpServletRequest req, HttpServletResponse resp,
							@RequestParam long time, @RequestParam String type, @RequestParam long uid) throws IOException {
		log.info("time:{} type:{} uid:{}", time, type, uid);
		return "suc";
	}



}
