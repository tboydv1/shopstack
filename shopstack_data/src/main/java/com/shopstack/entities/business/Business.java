package com.shopstack.entities.business;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author oluwatobi
 *
 */

@Entity
@Table(name="ss_business")
public class Business {
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="biz_id")
	private int bizId;
	
	@Column(name="biz_category")
	private String bizCategory;
	
	@Column(name="shop_name")
	private String bizName;
	
	@Column(name="biz_logo")
	private String bizLogoUri;
	
	@Column(name="biz_email")
	private String bizEmail;
	
	@Column(name="biz_website")
	private String bizWebsite;
	
	@Column(name="biz_phone")
	private String bizPhone;
	
	@Column(name="date_created")
	private Date dateAdded;

	public int getBizId() {
		return bizId;
	}

	public void setBizId(int bizId) {
		this.bizId = bizId;
	}

	public String getBizCategory() {
		return bizCategory;
	}

	public void setBizCategory(String bizCategory) {
		this.bizCategory = bizCategory;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizLogoUri() {
		return bizLogoUri;
	}

	public void setBizLogoUri(String bizLogoUri) {
		this.bizLogoUri = bizLogoUri;
	}

	public String getBizEmail() {
		return bizEmail;
	}

	public void setBizEmail(String bizEmail) {
		this.bizEmail = bizEmail;
	}

	public String getBizWebsite() {
		return bizWebsite;
	}

	public void setBizWebsite(String bizWebsite) {
		this.bizWebsite = bizWebsite;
	}

	public String getBizPhone() {
		return bizPhone;
	}

	public void setBizPhone(String bizPhone) {
		this.bizPhone = bizPhone;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Business [bizId=" + bizId + ", bizCategory=" + bizCategory + ", bizName=" + bizName + ", bizLogoUri="
				+ bizLogoUri + ", bizEmail=" + bizEmail + ", bizWebsite=" + bizWebsite + ", bizPhone=" + bizPhone
				+ ", dateAdded=" + dateAdded + "]";
	}
	
	

	
}