package com.tencent.feature.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @description: add your desc
 * @author: walker
 * @create: 2019-03-13 13:13
 **/
@Slf4j
@Service
public class AsyncService {

	public void syncGetUserInfo() {
		log.info("sync get userinfo.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	@Async
	public void asyncGetUserInfo() {
		log.info("async get userinfo.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void asyncGetUserInfoV2() {
		log.info("async get userinfoV2.");
		asyncGetUserInfo();
	}

}
