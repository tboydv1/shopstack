package com.shopstack.entities.shop;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="shop")
public class Shop {

	private int shop_id;
	private String name;
	private String logoPath;
	private String address;
	private String website;
	//add variable to reference shop owner id
	private String password;
	private Date date_created;
	public Shop(String name, String address, String website, String password, Date date_created) {
		super();
		this.name = name;
		this.address = address;
		this.website = website;
		this.password = password;
		this.date_created = date_created;
	}
	
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	
	
	
	
	
	
}