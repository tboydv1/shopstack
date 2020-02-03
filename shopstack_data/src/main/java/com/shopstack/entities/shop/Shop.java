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

import org.hibernate.annotations.CreationTimestamp;

import com.shopstack.entities.shopowner.ShopOwner;

@Entity
@Table(name="shop")
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shop_id")
	private int shopId;
	
	@Column(name="category")
	private String category;
	
	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="logo")
	private String logoUri;
	
	@Column(name="address")
	private String address;
	
	@Column(name="shop_email")
	private String shopEmail;
	
	@Column(name="website")
	private String website;

	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.PERSIST,
						CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="shop_owner_id")
	private ShopOwner shopOwner;
	
	@CreationTimestamp
	@Column(name="date_created", updatable= false)	
	private Date dateCreated;
	
	public Shop() {
		
	}
	
	public Shop(String category, String shopName, ShopOwner shopOwner, Date dateCreated) {
		super();
		this.category = category;
		this.shopName = shopName;
		this.shopOwner = shopOwner;
		this.dateCreated = dateCreated;
	}


	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLogoUri() {
		return logoUri;
	}

	public void setLogoUri(String logoUri) {
		this.logoUri = logoUri;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShopEmail() {
		return shopEmail;
	}

	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", category=" + category + ", shopName=" + shopName + ", logoUri=" + logoUri
				+ ", address=" + address + ", shopEmail=" + shopEmail + ", website=" + website + ", shopOwner="
				+ shopOwner + ", dateCreated=" + dateCreated + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}