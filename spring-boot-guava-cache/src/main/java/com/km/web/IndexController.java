package com.km.web;

import com.google.common.collect.ImmutableMap;
import com.km.entity.CountryCode;
import com.km.entity.User;
import com.km.service.CountryCodeService;
import com.km.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/21.
 */
@RestController
public class IndexController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private CountryCodeService countryCodeService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> users() {
        return userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public User findInfoById(@PathVariable("id") Long id) {
        return userService.findInfoById(id);
    }

    @GetMapping("/user/{id}/{name}")
    @ResponseBody
    public Map update(@PathVariable("id") Long id, @PathVariable("name") String name) {
        User user = userService.findUserById(id);
        System.out.println("user:" + user);
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setName(name);
        userService.update(user1);
        return ImmutableMap.of("ret", 0, "msg", "ok");
    }

    @GetMapping("/countrycode/{countrycode}")
    @ResponseBody
    public CountryCode getCountryCode(@PathVariable("countrycode") String countrycode) throws InterruptedException {
        logger.info("getCountryCode req:{}", countrycode);
        CountryCode countryCode = countryCodeService.getCounryCodeInfo(countrycode);
        logger.info("getCountryCode resp:{}", countryCode);
        return countryCode;
    }


}
