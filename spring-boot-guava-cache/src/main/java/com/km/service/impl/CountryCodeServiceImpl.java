package com.km.service.impl;

import com.km.entity.CountryCode;
import com.km.service.CountryCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2018-11-14 17:31
 **/
@Service
public class CountryCodeServiceImpl implements CountryCodeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	Map<String, CountryCode> countryCodeMap = new HashMap<>();

	public CountryCodeServiceImpl() {
		countryCodeMap.put("cn", new CountryCode("cn", "as"));
	}

	@Override
	public List list() {
		return Arrays.asList(countryCodeMap.values().toArray());
	}

	/**
	 * 获取缓存中的区域信息
	 * @param countryCode
	 * @return
	 */
	@Override
	@Cacheable(value = "countrycode", key = "'countrycode'.concat(#countryCode.toString())")
	public CountryCode getCounryCodeInfo(String countryCode) throws InterruptedException {
		//如果为空或者为null的时候，去获取结果
		logger.info("getCountryCode:{}", countryCode);

		//等待30ms
		Thread.sleep(1000);
		logger.info("after sleep.");
		CountryCode countryCode1 = countryCodeMap.get(countryCode);
		return countryCode1;
	}

	@Override
	@Cacheable(value = "countrycode", key = "'countrycode'.concat(#countrycode.toString())")
	public CountryCode updateCountryCodeCache(CountryCode countryCode) {
		return countryCode;
	}


}
