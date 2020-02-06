package com.shopstack.entities.user;

import java.util.Date;

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

import com.shopstack.entities.role.Role;


@Entity
@Table(name="ss_users")
public class BusinessUser {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ss_user_id")
	private int userId;
	
	@Column(name="ss_title")
	private String title;
	
	@NotNull
	@Column(name="ss_first_name")
	private String firstName;
	
	@NotNull
	@Column(name="ss_last_name")
	private String lastName;
	
	@Column(name="ss_address")
	private String address;
	
	@NotNull
	@Email
	@Column(name="ss_email")
	private String email;
	
	@NotNull
	@Column(name="ss_phone_number")
	private String phoneNumber;
	
	@NotNull
	@Column(name="ss_date_joined")
	private Date dateJoined;
	
	@NotNull
	@Column(name ="ss_password")
	private String password;
	
	@NotNull
	@Column(name="ss_enabled")
	private int enabled;
	
	@OneToOne
	@JoinColumn(name="role_id")
	private Role roleId;
	
	
	
	public BusinessUser() {
		
	}
	
	
	public BusinessUser(@NotNull String firstName, @NotNull String lastName, @NotNull @Email String email,
			@NotNull String contactNumber, @NotNull String password, @NotNull int enabled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = contactNumber;
		this.password = password;
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getUserId() {
		return userId;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return phoneNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.phoneNumber = contactNumber;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Role getRoleId() {
		return roleId;
	}


	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "BusinessUser [userId=" + userId + ", title=" + title + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", dateJoined=" + dateJoined
				+ ", enabled=" + enabled + ", roleId=" + roleId + "]";
	}
	
	
	
	
	
	
	
	
}
