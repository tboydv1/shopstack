package com.shopstack.entities.businessuser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.shopstack.entities.business.BusinessOutlet;
import com.shopstack.entities.role.Role;


/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="ss_user")
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
	
	
	@CreationTimestamp
	@Column(name="ss_date_joined")
	private Date dateJoined;
	
	@NotNull
	@Column(name ="ss_password")
	private String password;
	
	
	@Column(name="ss_enabled")
	private boolean enabled;


	@Column(name="ss_status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(mappedBy="userEmail")
	private List<Role> userRoles;
	
	@ManyToMany(
			cascade= {CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.MERGE, CascadeType.PERSIST}	
			)
	@JoinTable(
			name="business_outlet_has_employee",
			joinColumns=@JoinColumn(name="ss_user_id"),
			inverseJoinColumns=@JoinColumn(name="ss_business_outlet_id")
	)
	private List<BusinessOutlet> businessOutlets;
	
	
	public BusinessUser() {
		
	}
	
	public BusinessUser(@NotNull String firstName, @NotNull String lastName, @NotNull @Email String email,
			@NotNull String contactNumber, @NotNull String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = contactNumber;
		this.password = password;
		this.enabled = false;
		this.status = Status.PENDING;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
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


	public List<Role> getUserRoles() {
		return userRoles;
	}


	public void addUserRoles(Role newRole) {
		
		if((userRoles == null)) {
			userRoles = new ArrayList<>();
		}
		
		userRoles.add(newRole);
	}


	public List<BusinessOutlet> getBusinessOutlets() {
		return businessOutlets;
	}


	public void setBusinessOutlets(List<BusinessOutlet> business) {
		this.businessOutlets = business;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public Status getUserStatus() {
		return status;
	}

	public void setUserStatus(Status userStatus) {
		this.status = userStatus;
	}
	
	



	
	
	
	
	
	
	
	
	
}
