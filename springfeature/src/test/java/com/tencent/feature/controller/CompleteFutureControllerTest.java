package com.tencent.feature.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2019-02-28 13:20
 **/

public class CompleteFutureControllerTest {

	RestTemplate restTemplate;

	@Before
	public void beforeInit() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void test( ) {
		String url = "http://127.0.0.1:8080//async";
		String result = restTemplate.getForObject(url,String.class);
		System.out.println(result);

	}
}
