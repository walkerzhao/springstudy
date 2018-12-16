package com.tencent.feature.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2018-07-27 15:28
 **/
@Service
public class AsyncTask {

	public static Random random =new Random();

	@Async
	public void doTaskOne() throws Exception {
		taskOne(random);
	}

	static void taskOne(Random random) throws InterruptedException {
		System.out.println("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
	}

	@Async
	public void doTaskTwo() throws Exception {
		taskTwo(random);
	}

	static void taskTwo(Random random) throws InterruptedException {
		System.out.println("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
	}

	@Async
	public void doTaskThree() throws Exception {
		taskThree(random);
	}

	static void taskThree(Random random) throws InterruptedException {
		System.out.println("开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
	}
}
