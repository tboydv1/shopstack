package com.shopstack.entities.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="name")
	@NotNull(message= "is required")
	@Size(min=4, max=45)
	private String name;
	
	@Column(name="email")
	@NotNull
	@Email
	private String email;
	 
	@Column(name="organization_name")
	private String organizationName;
	
	@Column(name="contact_number")
	@NotNull(message="is required")
//	@Size(max=13)
	private int contactNumber;
	
	
	public Customer() {
		
	}
	
	
	public Customer( @NotEmpty @Size(min = 4, max = 45) String name, @NotNull @Email String email,
			@NotEmpty String organizationName, int contactNumber) {	
		this.name = name;
		this.email = email;
		this.organizationName = organizationName;
		this.contactNumber = contactNumber;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getOrganizationName() {
		return organizationName;
	}
	
	public void setOrganization_name(String organizationName) {
		this.organizationName = organizationName;
	}



	public int getContactNumber() {
		return contactNumber;
	}



	public void setContact_number(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", organization_name=" + organizationName
				+ ", contact_number=" + contactNumber + "]";
	}


	 
}
