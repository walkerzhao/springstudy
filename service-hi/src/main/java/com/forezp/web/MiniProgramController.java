package com.forezp.web;


import com.forezp.dao.LgnDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * redirect problem reproduce.
 *
 * @author zhaoyu
 * @date 2018-07-09
 */
//@Controller
@RequestMapping("/web")
@Controller
public class MiniProgramController {

	private static final Logger log = LoggerFactory.getLogger(MiniProgramController.class);

	@Autowired
	private LgnDao lgnDao;

	/**
	 * @param
	 * @return
	 */
	@RequestMapping("/testRedirect1")
	public String getTest1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String redirectUrl =  "redirect:" + "http://www.baidu.com";
		Random random = new Random();
		int data = random.nextInt(21_0000_0000);
		redirectUrl = redirectUrl + "/" + data;
//		resp.sendRedirect(redirectUrl);
		return redirectUrl;
	}

//	/**
//	* one resolve method
//	 * @param
//	 * @return
//	 */
//	@RequestMapping("/testRedirect1")
//	public void getTest2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		String redirectUrl =  "http://www.baidu.com";
//		Random random = new Random();
//		int data = random.nextInt(21_0000_0000);
//		redirectUrl = redirectUrl + "/" + data;
//		resp.sendRedirect(redirectUrl);
//	}

//	/**
//	 *  获取微信绑定手机号
//	 * @param
//	 * @return
//	 */
//	@RequestMapping("/testRedirect")
//	public void getTest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		String redirectUrl =  "http://www.baidu.com";
//		Random random = new Random();
//		int data = random.nextInt(21_0000_0000);
//		redirectUrl = redirectUrl + "/" + data;
//		try {
//			int data1 = 10 / 0;
//		}catch (Exception e) {
//			resp.sendRedirect(redirectUrl);
//			return;
//		}
//		resp.sendRedirect(redirectUrl);
////		return ;
//	}


}
