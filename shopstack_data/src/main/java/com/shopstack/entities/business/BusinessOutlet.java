package com.shopstack.entities.business;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.shopstack.entities.businessuser.BusinessUser;

/**
 * @author oluwatobi
 *
 */


@Entity
@Table(name="ss_business_outlet")
public class BusinessOutlet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ss_business_outlet_id")
	private int outletId;
	
	@Column(name="ss_outlet_display_name")
	@NotNull
	private String displayName; 
	
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="location")
	private String location;
	
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="date_Added")
	private Date dateAdded;
	
	@ManyToOne(
				cascade= {CascadeType.DETACH, CascadeType.REFRESH,
				CascadeType.MERGE, CascadeType.PERSIST}
	)
	@JoinColumn(name="ss_business_biz_id")
	private Business businessId;

	@ManyToMany( 
			cascade= {CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.MERGE, CascadeType.PERSIST}	
			)
	@JoinTable(
			name="business_outlet_has_employee",
			joinColumns=@JoinColumn(name="ss_business_outlet_id"),
			inverseJoinColumns=@JoinColumn(name="ss_user_id")
	)
	private List<BusinessUser> employees;
	
	public BusinessOutlet() {
		
	}
	
	
	public BusinessOutlet(int outletId, @NotNull String displayName, @NotNull String location, Business businessId) {
		super();
		this.outletId = outletId;
		this.displayName = displayName;
		this.location = location;
		this.businessId = businessId;
	}

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
