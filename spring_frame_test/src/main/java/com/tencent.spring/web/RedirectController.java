package com.tencent.spring.web;

import com.tencent.spring.dao.LgnDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @link  https://github.com/spring-projects/spring-boot/issues/13771
 * redirect problem reproduce.
 * redirect may produce oom. has fixed by spring framework
 *
 * @author zhaoyu
 * @date 2018-07-09
 */
@RestController
public class RedirectController {

	private static final Logger log = LoggerFactory.getLogger(RedirectController.class);

	@Autowired
	private LgnDao lgnDao;

	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "testRedirect")
	public String testRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String redirectUrl =  "redirect:" + "http://www.baidu.com";
		Random random = new Random();
		int data = random.nextInt(21_0000_0000);
		redirectUrl = redirectUrl + "/" + data;
		return redirectUrl;
	}

	@RequestMapping(value = "testRedirect2")
	public String testRedirect2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String redirectUrl =  "redirect:" + "http://www.baidu.com";
		Random random = new Random();
		int data = random.nextInt(21_0000_0000);
		redirectUrl = redirectUrl + "/" + data;
		resp.sendRedirect(redirectUrl);
		return "suc";
	}

}
