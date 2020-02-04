package com.shopstack.entities.shopowner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.shopstack.entities.user.User;



@Entity
@Table(name="shop_owner")
public class ShopOwner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shop_owner_id")
	@NotNull
	private int id;
	
	
	@NotNull(message="is required")
	@Size(min=1)
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1)
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address")
	private String address;

	@Email
	@NotNull
	@Column(name="email")
	private String email;
	
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User userDetail;
	
	public ShopOwner() {
		
	}
	

	public ShopOwner(@NotNull(message = "is required") @Size(min = 1) String firstName,
			@NotNull(message = "is required") @Size(min = 1) String lastName, String address,
			@Email @NotNull String email, String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.contactNumber = contactNumber;
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		if(first_name != null)
			this.firstName = first_name;
		else
			this.lastName = null;
	}

	public String getLastName() {
		
		return lastName;
	}

	public void setLastName(String last_name) {
		if(last_name != null)
			this.lastName = last_name;
		else
			this.lastName = null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		
		if(email != null)
			this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if(address != null)
			this.address = address;
	}
	

	public User getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(User userDetail) {
		
		if(userDetail != null)
			this.userDetail = userDetail;
	}

	public void setContactNumber(String contactNumber) {
		
		if(contactNumber != null)
			this.contactNumber = contactNumber;
	}
	
	public String getContactNumber() {
		return this.contactNumber;
	}

	@Override
	public String toString() {
		return "Shopowner [ first_name=" + firstName + ", last_name=" + lastName + ", email=" + email
				+ ", contact_number=" + contactNumber + ", address=" + address + "]";
	}
	

}
