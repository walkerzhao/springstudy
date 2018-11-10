package com.tencent.spring.web;


import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 2018/11/10.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class TestRestTemplateOOMControllerTest {



    String url1 = "http://127.0.0.1:8763/testRestTemplate1";

    String url2 = "http://127.0.0.1:8763/testRestTemplate2";

    String url3 = "http://127.0.0.1:8763/testParam?time={time}&type={type}&uid={uid}";

    RestTemplate restTemplate;

    @Before
    public void init() {
        restTemplate = new RestTemplateBuilder().build();
    }


    /**
     * request once
     */
    @Test
    public void testRestTemplate1() {
        System.out.println("hello,world");
        restTemplate.getForEntity(url1,String.class);
    }


    /**
     * request once
     */
    @Test
    public void testRestTemplate2() {
        System.out.println("hello,world");
        restTemplate.getForEntity(url2,String.class);
    }

    /**
     * test param
     */
    @Test
    public void testRestTemplate3() {
        //测试传递参数
        System.out.println("hello,world");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("time", System.currentTimeMillis()/1000);
        paramMap.put("type", "phonebind");
        paramMap.put("uid", 12356);
        restTemplate.getForEntity(url3,String.class, paramMap);
    }

    /**
     * 压测,优先使用ab测试: ab -n 10000000 -c 50 "127.0.0.1:8763/testRestTemplate1"
     */
    @Test
    public void testRestTemplate1WithPressure() {

    }

    /**
     * ab -n 10000000 -c 50 "127.0.0.1:8763/testRestTemplate2"
     */
    @Test
    public void testRestTemplate2WithPressure() {

    }

}