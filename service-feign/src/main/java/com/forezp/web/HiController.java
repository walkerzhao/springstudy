package com.forezp.web;

import com.forezp.service.SchedualServiceHi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
//@RestController
@RestController
@Slf4j
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(name="/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        log.info("test:{}",name);
        String result = schedualServiceHi.sayHiFromClientOne(name);
        log.info("result:{}", result);
        return result;
    }



}
