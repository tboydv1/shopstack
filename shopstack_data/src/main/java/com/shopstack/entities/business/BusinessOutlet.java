package com.shopstack.entities.business;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author oluwatobi
 *
 */
public class BusinessOutlet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ss_business_outlet_id")
	private int outletId;
	
	
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="location")
	private String location;
	
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="date_Added")
	private Date dateAdded;
	
	@Column(name="ss_business_biz_id")
	private Business businessId;

	@Column(name="ss_business_account_number")
	public int getOutletId() {
		return outletId;
	}

	public void setOutletId(int outletId) {
		this.outletId = outletId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Business getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Business businessId) {
		this.businessId = businessId;
	}

	@Override
	public String toString() {
		return "BusinessOutlet [outletId=" + outletId + ", email=" + email + ", location=" + location + ", phone="
				+ phone + ", dateAdded=" + dateAdded + ", businessId=" + businessId + "]";
	}
	
//	private Account account;
	
	
}
