package com.shopstack.dao.user;

import java.util.List;

import com.shopstack.entities.user.BusinessUser;

public interface BusinessUserDao {

	public List<BusinessUser> getUsers();
	
	public void saveUser(BusinessUser theUser);
	
	public BusinessUser loadUserByEmail(String username);
}
