//package com.shopstack.service.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.shopstack.dao.user.TokenRepository;
//import com.shopstack.dao.user.BusinessUserDao;
//import com.shopstack.entities.user.BusinessUser;
//import com.shopstack.entities.user.VerificationToken;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private TokenRepository tokenRepositoryImpl;
//	
//	@Autowired
//	private BusinessUserDao userDaoImpl;
//	
//	
//	@Override
//	public void createVerificationTokenForUser(BusinessUser businessUser, String token) {
//			
//		final VerificationToken userToken = new VerificationToken(token, businessUser);
//		tokenRepositoryImpl.save(userToken);
//	}
//
//
//	@Override
//	public VerificationToken getUserVerificationToken(String token) {
//		
//		return tokenRepositoryImpl.findByToken(token);
//		
//	}
//
//
//	@Override
//	public void saveRegisteredUser(BusinessUser businessUser) {
//		
//		userDaoImpl.saveUser(businessUser);
//	}
//	
//
//}
