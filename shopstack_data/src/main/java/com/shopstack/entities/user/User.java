package com.shopstack.entities.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.shopstack.entities.shopowner.ShopOwner;

@Entity
@Table(name="user")
public class User {

	
	@Id
	@NotNull
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="enabled")
	private int enabled;
	
	@OneToOne(mappedBy="userDetail", cascade= {CascadeType.DETACH, CascadeType.MERGE,
				CascadeType.PERSIST, CascadeType.REFRESH})
	private ShopOwner shopOwner;
	
	
//	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//	@OneToMany(mappedBy = "userDetail",
//				cascade= 
//				{CascadeType.DETACH, CascadeType.MERGE,
//				CascadeType.PERSIST,CascadeType.REFRESH})
	
	@NotNull
	@Column(name="role")
	private String role;
	
	public User() {
		
		
		//set default enabled value to 0 
		this.enabled = 0;
	}
	
	public User(@NotNull String username, @NotNull String password) {
		
		this.enabled = 0;
		this.role = "ROLE_MANAGER";
	}
		


	public User(@NotNull String username, @NotNull String password, @NotNull int enabled,
			@NotNull String role) {
			
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public ShopOwner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(ShopOwner shopOwner) {
		this.shopOwner = shopOwner;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", shopOwner="
				+ shopOwner + ", role=" + role + "]";
	}

	
	
	
	
	
}
