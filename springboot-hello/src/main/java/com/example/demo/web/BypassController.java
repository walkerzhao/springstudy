package com.example.demo.web;

import com.example.demo.utils.VersionUtils;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 模拟bypass 接口,返回bypass
 * Created by andy on 2018/6/18.
 */
@RestController
public class BypassController {

    public static List<String> appVerList = new ArrayList<>();

    static {
        for(int i=0; i<30000; i++) {
            Random random = new Random();
            random.nextInt(20);

            int a = random.nextInt(20);
            int b = random.nextInt(20);
            int c = random.nextInt(20);
            String randomStr = a+"."+b + "."+c;
            appVerList.add(randomStr);
        }
    }

    @RequestMapping(name="getBypass")
    public String getBypass(@RequestParam String version) {
        forTest(version);


        return "3";
    }

    private static void forTest(String version) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //遍历三万的数据,比较字符串
        System.out.println("list size:" + appVerList.size());
        for(String versionStr : appVerList) {
            try {
                int ret = VersionUtils.compareVersion(version, versionStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stopWatch.stop();
        Long time = stopWatch.getTotalTimeMillis();
        System.out.println("time:" + time);
    }


    public static void main(String[] args) {

        System.out.println(appVerList.get(0));
//        while(true) {
//            forTest("1.24.3");
//        }
    }


}
