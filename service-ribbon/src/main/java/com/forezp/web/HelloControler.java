package com.forezp.web;

import com.forezp.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
@Slf4j
public class HelloControler {

    @Autowired
    HelloService helloService;
    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        log.info("test");
        return helloService.hiService(name);
    }


}
