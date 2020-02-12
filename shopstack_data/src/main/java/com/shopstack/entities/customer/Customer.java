package com.shopstack.entities.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessOutlet;

/**
 * @author adefunmi
 *
 */
@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="firstname")
	private String firtname;
	
	@Column(name="lastname")
	private String lastname;
	
	@NotNull
	@Column(name="email")
	private String email;
	 
	@Column(name="phone_number")
	private String contactNumber;
	
	@ManyToOne
	@JoinColumn(name="ss_business_outlet_ss_business_outlet_id")
	private BusinessOutlet businessOutlet;
	
	
	public Customer() {
		
	}
	
	
	
	public Customer(@NotNull String email) {
		super();
		this.email = email;
	}

	public Customer(String info, BusinessOutlet existingBusiness) {
		super();
		this.email = info;
		this.businessOutlet = existingBusiness;
	}



	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getFirtname() {
		return firtname;
	}


	public void setFirtname(String firtname) {
		this.firtname = firtname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public BusinessOutlet getBusinessOutlet() {
		return businessOutlet;
	}


	public void setBusinessOutlet(BusinessOutlet businessOutlet) {
		this.businessOutlet = businessOutlet;
	}



	
	
	

}
