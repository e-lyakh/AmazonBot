package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table (name = "goods")
public class Good {
	
	@Id
	@Column (name = "asin", length = 50)
	private String asin;
	
	@Column (name = "name", length = 100, nullable = false)
	private String name;
	
	@Column (name = "shop_url", length = 256, nullable = false)
	private String shopUrl;	
	
	public Good() {
		this.asin = "init_asin";
		this.name = "init_name";
		this.shopUrl = "init_url";
	}	
	public Good(String asin, String name, String shopUrl) {
		this.asin = asin;
		this.name = name;
		this.shopUrl = shopUrl;		
	}

}