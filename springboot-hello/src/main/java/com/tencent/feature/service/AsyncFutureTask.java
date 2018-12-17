package com.tencent.feature.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2018-07-27 15:28
 **/
@Service
public class AsyncFutureTask {

	public static Random random =new Random();

	@Async
	public Future<String> doTaskOne() throws Exception {
		System.out.println("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务一完成");
	}

	@Async
	public Future<String> doTaskTwo() throws Exception {
		System.out.println("开始做任务2");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务2，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务2完成");
	}

	@Async
	public Future<String> doTaskThree() throws Exception {
		System.out.println("开始做任务3");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务3，耗时：" + (end - start) + "毫秒");
		return new AsyncResult<>("任务3完成");
	}

}
