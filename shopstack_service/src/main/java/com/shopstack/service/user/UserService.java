package com.shopstack.service.user;

import com.shopstack.entities.user.User;
import com.shopstack.entities.user.VerificationToken;

public interface UserService {

	public void createVerificationTokenForUser(final User user, final String token);
	public VerificationToken getUserVerificationToken(String token);
	public void saveRegisteredUser(User user);
	
}
