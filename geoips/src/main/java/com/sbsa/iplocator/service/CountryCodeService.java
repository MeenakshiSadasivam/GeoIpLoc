/**
 * 
 */
package com.sbsa.iplocator.service;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.maxmind.geoip.LookupService;

/**
 * @author Administrator
 *
 */
@Component
public class CountryCodeService {
	
	private LookupService lookupService;
	
	public String getCountryCode(String ipAddress) {
		try {
			return getLookupService().getCountry(ipAddress).getCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "N/A";
	}
	
	
	private LookupService getLookupService() throws IOException {
		if(null == this.lookupService) {
			String path = Thread.currentThread().getContextClassLoader().getResource("GeoIPLite.dat").getPath();
			this.lookupService = new LookupService(path, LookupService.GEOIP_MEMORY_CACHE);
		}
		return this.lookupService;
	}
	
}
