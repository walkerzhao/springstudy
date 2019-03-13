package com.tencent.feature.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2019-02-28 13:20
 **/

public class TestControllerTest {

	RestTemplate restTemplate;

	@Before
	public void beforeInit() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testSync( ) {
		String url = "http://127.0.0.1:8080/syncGetUserInfo";
		String result = restTemplate.getForObject(url,String.class);
		System.out.println(result);
	}

	@Test
	public void testASync( ) {
		String url = "http://127.0.0.1:8080/asyncGetUserInfo";
		String result = restTemplate.getForObject(url,String.class);
		System.out.println(result);
	}

	@Test
	public void testASyncV2( ) {
		String url = "http://127.0.0.1:8080/asyncGetUserInfoV2";
		String result = restTemplate.getForObject(url,String.class);
		System.out.println(result);
	}
}
