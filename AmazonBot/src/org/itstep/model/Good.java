package org.itstep.model;

/**
 * 
 * @author Evgeniy Lyakh
 *
 */
public class Good {
	
	private String asin;
	private String name;
	private String shopUrl;
	
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	
	public Good() {	}	
	public Good(String asin, String name, String shopUrl) {		
		this.asin = asin;
		this.name = name;
		this.shopUrl = shopUrl;
	}
	
	public String ToString() {
		return "Good: " + this.name + ", ASIN: '" + this.asin + ", url: " + this.shopUrl;
	}
}