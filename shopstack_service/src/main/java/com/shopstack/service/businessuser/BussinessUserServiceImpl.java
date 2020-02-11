package com.shopstack.service.businessuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.business.BusinessDao;
import com.shopstack.dao.businessuser.BusinessUserDao;
import com.shopstack.entities.user.BusinessUser;
import com.shopstack.entities.user.VerificationToken;

@Service
public class BussinessUserServiceImpl implements BussinessUserService{

	
	@Autowired
	private BusinessUserDao bussinessUserDaoImpl;
	
	@Override
	public void createVerificationTokenForUser(BusinessUser businessUser, String token) {
		
		
		
		
	}

	@Override
	public VerificationToken getUserVerificationToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRegisteredUser(BusinessUser businessUser) {
		
		bussinessUserDaoImpl.saveUser(businessUser);
		
	}

	
}
