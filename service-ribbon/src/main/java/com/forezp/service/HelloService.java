package com.forezp.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@Service
@Slf4j
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
    	log.info("hi:{}",name);
    	return "name";
//        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

}
