package com.forezp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2019-01-08 10:56
 **/
@Configuration
public class Config {

	@Value("${serv_url.reg}")
	public String servRegUrl;
}
