/**
 * 
 */
package com.sbsa.app.model;

/**
 * @author Administrator
 *
 */
public class GeoIp {
	
	private String ipAddress;
	
	private String countryCode;

	public GeoIp(String ipAddress, String countryCode) {
		// TODO Auto-generated constructor stub
		this.ipAddress=ipAddress;
		this.countryCode=countryCode;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeoIp [ipAddress=" + ipAddress + ", countryCode=" + countryCode + "]";
	}
	
	

}
