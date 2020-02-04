package com.shopstack.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.user.TokenRepository;
import com.shopstack.dao.user.UserDao;
import com.shopstack.entities.user.User;
import com.shopstack.entities.user.VerificationToken;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TokenRepository tokenRepositoryImpl;
	
	@Autowired
	private UserDao userDaoImpl;
	
	
	@Override
	public void createVerificationTokenForUser(User user, String token) {
			
		final VerificationToken userToken = new VerificationToken(token, user);
		tokenRepositoryImpl.save(userToken);
	}


	@Override
	public VerificationToken getUserVerificationToken(String token) {
		
		return tokenRepositoryImpl.findByToken(token);
		
	}


	@Override
	public void saveRegisteredUser(User user) {
		
		userDaoImpl.saveUser(user);
	}
	

}
