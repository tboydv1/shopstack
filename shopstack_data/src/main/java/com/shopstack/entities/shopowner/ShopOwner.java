package com.shopstack.entities.shopowner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



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
	
	
//	@Size(max=13)
	@NotNull
	@Column(name="contact_number")
	private String contactNumber;
	
//	@Column(name="role")
//	private String role;
	
	@NotNull
	@Column(name="username")
	private String userName;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	//constructor should initialize  all instance variables
	public int getId() {
		return id;
	}
	
	public ShopOwner() {
		
	}

	
	public ShopOwner(@NotNull(message = "is required") @Size(min = 1) String firstName,
			@NotNull(message = "is required") @Size(min = 1) String lastName, String address,
			@Email @NotNull String email, @NotNull String contactNumber, @NotNull String userName,
			@NotNull String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.contactNumber = contactNumber;
		this.userName = userName;
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContactNumber(String contactNumber) {
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