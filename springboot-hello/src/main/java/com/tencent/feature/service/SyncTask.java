package com.tencent.feature.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * spring boot的异步任务 demo
 * http://blog.didispace.com/springbootasync/
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2018-07-27 15:24
 **/
@Service
public class SyncTask {

	public static Random random =new Random();

	public void doTaskOne() throws Exception {
		AsyncTask.taskOne(random);
	}

	public void doTaskTwo() throws Exception {
		AsyncTask.taskTwo(random);
	}

	public void doTaskThree() throws Exception {
		AsyncTask.taskThree(random);
	}
}
