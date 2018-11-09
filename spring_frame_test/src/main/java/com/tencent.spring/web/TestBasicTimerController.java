package com.forezp.web;


import com.forezp.dao.LgnDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 *  restTemplate请求问题
 * @link https://github.com/spring-cloud/spring-cloud-netflix/issues/947
 *
 * @author zhaoyu
 * @date 2018-11-09
 */
@RestController
public class TestBasicTimerController {

	private static final Logger log = LoggerFactory.getLogger(TestBasicTimerController.class);

	@Autowired
	private LgnDao lgnDao;

	/**
	 * @param
	 * @return
	 */
	@RequestMapping(name="/testRestTemplate")
	public String testRestTemplate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String redirectUrl =  "redirect:" + "http://www.baidu.com";
		Random random = new Random();
		int data = random.nextInt(21_0000_0000);
		redirectUrl = redirectUrl + "/" + data;
//		resp.sendRedirect(redirectUrl);
		return "suc";
	}




}
