package com.shopstack.entities.shopowner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="shop_owner")
public class Shopowner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="shop_owner_id")
	@NotNull
	private int id;

	@NotEmpty
	@Column(name="first_name")
	 private String first_name;
	
	@Size(min=2, max=45)
	@Column(name="last_name")
	 private String last_name;
	
	@NotEmpty @Email
	@Column(name="email")
	 private String email;
	
	@NotEmpty
	@Size(max=13)
	@Column(name="contact_number")
	 private int contact_number;
	
	
	@Column(name="address")
	 private String address;
	 
	@Column(name="role")
	private String role;
	
	public Shopowner(String first_name, @Size(min = 2, max = 45) String last_name,
			@NotEmpty @Email String email,  @NotEmpty  int contact_number, String address, String role) {
	
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.contact_number = contact_number;
		this.address = address;
		this.role = role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact_number() {
		return contact_number;
	}

	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Shopowner [ first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", contact_number=" + contact_number + ", address=" + address + ", role=" + role + "]";
	}
	

}
