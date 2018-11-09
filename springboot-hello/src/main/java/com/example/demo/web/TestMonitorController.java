package com.example.demo.web;

import com.example.demo.utils.VersionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 模拟bypass 接口,返回bypass
 * Created by andy on 2018/6/18.
 */
@RestController
public class TestMonitorController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(name="testMonitor")
    public String testMonitor(@RequestParam String version) {
//        forTest(version);
        System.out.println("hello,world");

        //调用restTemplate
        ResponseEntity<String> responseEntity = null;
//        restTemplate.getForObject("http://testeurekabrixtonclient/orders/1", String.class);
        String url = "https://www.baidu.com";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);



        return "3";
    }

}
