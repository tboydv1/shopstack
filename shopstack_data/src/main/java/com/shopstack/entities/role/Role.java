package com.shopstack.entities.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shopstack.entities.businessuser.BusinessUser;


/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="role")
	private String role;
	
	@ManyToOne
	@JoinColumn(name="user_email")
	private BusinessUser userEmail;
	
	public Role() {
		
	}
	
	public Role(int id, String role) {
		
	}
	
	public Role(String role) {
		
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BusinessUser getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(BusinessUser userEmail) {
		this.userEmail = userEmail;
	}
	
	

	        

	
	
	

}
