package com.shopstack.dao.businessuser;

import com.shopstack.entities.businessuser.VerificationToken;

public interface TokenDao {

	
	public void saveToken(VerificationToken newToken);
	
	public VerificationToken findByToken(String savedToken);
}
