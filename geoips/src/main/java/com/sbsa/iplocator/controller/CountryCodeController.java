/**
 * 
 */
package com.sbsa.iplocator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbsa.iplocator.service.CountryCodeService;

/**
 * @author Administrator
 *
 */
@RestController
public class CountryCodeController {
	
	@Autowired
	private CountryCodeService countryCodeService;

	/**
	 * To get the country code based on the IP address passed to the service
	 * 
	 * @param ipAddress
	 * @return String
	 */
	@RequestMapping("/geoip")
	public String getCountryCodeBasedOnIP(@RequestParam(value="ip") String ipAddress) {
		return countryCodeService.getCountryCode(ipAddress);
	}


}
