package com.shopstack.dao.user;

import com.shopstack.entities.user.VerificationToken;

public interface TokenRepository {

	public void save(VerificationToken userToken);

	public VerificationToken findByToken(String token);
}
