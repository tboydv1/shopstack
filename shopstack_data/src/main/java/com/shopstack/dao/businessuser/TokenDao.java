package com.shopstack.dao.businessuser;

import com.shopstack.entities.user.VerificationToken;

public interface TokenDao {

	
	public void saveToken(VerificationToken newToken);
	
	public VerificationToken findByToken(String savedToken);
}
