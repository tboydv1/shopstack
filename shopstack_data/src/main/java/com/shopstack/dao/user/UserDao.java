package com.shopstack.dao.user;

import java.util.List;

import com.shopstack.entities.user.User;

public interface UserDao {

	public List<User> getUsers();
	
	public void saveUser(User theUser);
}
