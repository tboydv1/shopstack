package com.shopstack.service.businessuser;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.businessuser.BusinessUserDao;
import com.shopstack.dao.businessuser.TokenDao;
import com.shopstack.entities.businessuser.BusinessUser;
import com.shopstack.entities.businessuser.VerificationToken;
import com.shopstack.entities.role.Role;

/**
 * @author oluwatobi
 *
 */
@Service
public class BussinessUserServiceImpl implements BussinessUserService{

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private BusinessUserDao bussinessUserDaoImpl;
	
	@Autowired
	TokenDao tokenRepository;
	
	@Override
	public void createVerificationTokenForUser(BusinessUser businessUser, String token) {
		
		 VerificationToken myToken = new VerificationToken(token, businessUser);
	      tokenRepository.saveToken(myToken);
		
	}

	@Override
	public VerificationToken getUserVerificationToken(String token) {
		
		 return tokenRepository.findByToken(token);
	}

	@Override
	public BusinessUser registerNewUserAccount(BusinessUser businessUser, String role) throws EmailExistsException {
		
		//check that user is not already registered
		BusinessUser savedUsers = bussinessUserDaoImpl.loadUserByEmail(businessUser.getEmail());
		
		if (emailExsits(businessUser.getEmail())) {  
			
            throw new EmailExistsException(
              "There is an account with that email address:  + accountDto.getEmail()");
        
		}
		else {
			businessUser.addUserRoles(new Role(role));
			
			logger.info("Calling BusinessDAO save method");
			bussinessUserDaoImpl.saveUser(businessUser);
			
			return businessUser;
		
		}
		
		
	}

	private boolean emailExsits(String email) {
		
		 BusinessUser user = bussinessUserDaoImpl.loadUserByEmail(email);
	        if (user != null) {
	            return true;
	        }
	        return false;

	}
	
}
