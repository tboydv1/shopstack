package com.shopstack.entities.shop;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shopstack.entities.shopowner.ShopOwner;

//@Entity
//@Table(name="shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shop_id")
	private int shop_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="logo")
	private String logoPath;
	
	@Column(name="address")
	private String address;
	
	@Column(name="website")
	private String website;
	//add variable to reference shop owner id
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.PERSIST,
						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="shop_owner_id")
	private ShopOwner shopOwner;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	public Shop(String name, String address, String website, String password, Date date_created) {
		super();
		this.name = name;
		this.address = address;
		this.website = website;
		this.password = password;
		this.dateCreated = date_created;
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
		return dateCreated;
	}
	public void setDate_created(Date date_created) {
		this.dateCreated = date_created;
	}
	
	
	
	
	
	
	
}