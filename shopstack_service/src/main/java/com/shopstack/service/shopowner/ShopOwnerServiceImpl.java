package com.shopstack.service.shopowner;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.shopowner.ShopOwnerDao;
import com.shopstack.entities.shopowner.ShopOwner;


/**
 * @author oluwatobi
 *
 */
@Service
public class ShopOwnerServiceImpl implements ShopOwnerService {

	
	private Logger logger = Logger.getLogger(ShopOwnerServiceImpl.class.getName());
	
	@Autowired
	private ShopOwnerDao shopOwnerDaoImpl;

	
	/**
	 * password is encoded with {noop}
	 * before its passed to the dao layer
	 *
	 */
	@Override
	public ShopOwner addShopOwner(ShopOwner theShopOwner) {
		
		logger.info("Shop owner details "+ theShopOwner + "/nShop owner credential "+theShopOwner.getUserDetail());

		if(findByEmail(theShopOwner.getEmail()) == null) {
		
			//append {noop} before password
			String password = theShopOwner.getUserDetail().getPassword();
			
			theShopOwner.getUserDetail().setPassword("{noop}".concat(password));
			
			theShopOwner.getUserDetail().setEnabled(0);
			theShopOwner.getUserDetail().setRole("ROLE_USER");
			
			shopOwnerDaoImpl.saveShopOwner(theShopOwner);
			
			return theShopOwner;
		
		}
		
		//returns null if user exists
			return null;
		
	}


	@Override
	public ShopOwner findByEmail(String email) {
		
		ShopOwner resultList = shopOwnerDaoImpl.findByEmail(email);
		
		if(resultList == null) {
			
			return null;
		}
		
		return resultList;
		
	}
	


}
