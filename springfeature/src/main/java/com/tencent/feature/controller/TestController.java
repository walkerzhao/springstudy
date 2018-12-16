package com.tencent.feature.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * just a test
 *
 * @author zhaoyu
 * @date 2018-07-09
 */
@RestController
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);


	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "test1")
	public String test(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		log.info("test1");
		return "test1";
	}


}
