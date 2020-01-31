package com.shopstack.entities.autorities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.shopstack.entities.user.User;


/**
 * @author oluwatobi
 *
 */
@Entity
@Table( name = "authorities",
uniqueConstraints = { @UniqueConstraint( columnNames = { "authority", "username" } ) } )
public class Authority implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3261313116767139509L;
	
	@Id
	@Column(name="authority")
	@NotNull
	private String authority;
	
	@NotNull
//	@Cascade(CascadeType.MERGE)
	@ManyToOne(cascade= 
		{CascadeType.DETACH, CascadeType.MERGE,
		CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="username", nullable=false, insertable=true)
	private User userDetail;
	
	public Authority() {
		
	}

	public Authority(String authority) {
		
		this.authority = authority;
	}


	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(User userDetail) {
		this.userDetail = userDetail;
	}
	
	
	

	
	
	
	
	
	

	
	
	
	
	
}
