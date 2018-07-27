package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2018-07-27 15:25
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskTest {

	@Autowired
	SyncTask syncTask;


	@Autowired
	AsyncTask asyncTask;

	@Autowired
	AsyncFutureTask asyncFutureTask;


	@Test
	public void testSyncTask() throws Exception {
		syncTask.doTaskOne();
		syncTask.doTaskTwo();
		syncTask.doTaskThree();
	}

	@Test
	public void testASyncTask() throws Exception {
		asyncTask.doTaskOne();
		asyncTask.doTaskTwo();
		asyncTask.doTaskThree();

		Thread.sleep(10_000);
	}

	@Test
	public void testASyncFutureTask() throws Exception {
		long start = System.currentTimeMillis();
		Future<String> task1 = asyncFutureTask.doTaskOne();
		Future<String> task2 = asyncFutureTask.doTaskTwo();
		Future<String> task3 = asyncFutureTask.doTaskThree();

		while(true) {
			if(task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
		System.out.println("task1 result:"+ task1.get());
	}



}
