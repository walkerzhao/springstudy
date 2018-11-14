package com.km.entity;

import lombok.Data;

/**
 * @description: add your desc
 * @author: ewanzhao
 * @create: 2018-11-14 17:29
 **/
@Data
public class CountryCode {
	private String countrycode;
	private String servRegion;

	public CountryCode(String countrycode, String servRegion) {
		this.countrycode = countrycode;
		this.servRegion = servRegion;
	}
}
