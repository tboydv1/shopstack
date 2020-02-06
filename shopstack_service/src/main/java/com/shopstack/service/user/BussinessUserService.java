package com.shopstack.service.user;

import com.shopstack.entities.user.BusinessUser;
import com.shopstack.entities.user.VerificationToken;

public interface BussinessUserService {

	public void createVerificationTokenForUser(final BusinessUser businessUser, final String token);
	
	public VerificationToken getUserVerificationToken(String token);
	
	public void saveRegisteredUser(BusinessUser businessUser);
	
}
