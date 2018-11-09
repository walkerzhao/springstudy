package com.forezp.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录服务client
 */
//@FeignClient(value = "serv-lgn")
@FeignClient(value = "serv-lgn", url = "${serv_url.lgn:}")
public interface LgnDao {

    @RequestMapping(method = RequestMethod.POST, value = "/open/passwordLogin")
    String appPasswordLogin(@RequestHeader("X-Real-IP") String userIp, @RequestBody String req);

}
