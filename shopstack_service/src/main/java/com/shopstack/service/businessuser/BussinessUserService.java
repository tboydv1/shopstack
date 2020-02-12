package com.shopstack.service.businessuser;

import com.shopstack.entities.businessuser.BusinessUser;
import com.shopstack.entities.businessuser.VerificationToken;

/**
 * @author oluwatobi
 *
 */
public interface BussinessUserService {

	public void createVerificationTokenForUser(final BusinessUser businessUser, final String token);
	
	public VerificationToken getUserVerificationToken(String token);
	
	public BusinessUser registerNewUserAccount(BusinessUser businessUser, String role) throws EmailExistsException;
	
	
	
}
