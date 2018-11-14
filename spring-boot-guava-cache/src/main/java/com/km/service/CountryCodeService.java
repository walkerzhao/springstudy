package com.km.service;

import com.km.entity.CountryCode;

import java.util.List;

public interface CountryCodeService {

	List<CountryCode> list();

	public CountryCode getCounryCodeInfo(String countryCode) throws InterruptedException;

	public CountryCode updateCountryCodeCache(CountryCode countryCode);
}
