package com.shopstack.service.shopowner;

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
	public void addShopOwner(ShopOwner tempShopOwner) {
		
		logger.info("Shop owner details "+ tempShopOwner + "/nShop owner credential "+tempShopOwner.getUserDetail());
		
		//set enabled status and role for manager
		tempShopOwner.getUserDetail().setEnabled(1);
		tempShopOwner.getUserDetail().setRole("ROLE_MANAGER");
		
		//append {noop} before password
		String password = tempShopOwner.getUserDetail().getPassword();
		
		logger.info("Raw password " + password);
		
		tempShopOwner.getUserDetail().setPassword(appendBeforePassword(password, "{noop}"));
		
		logger.info("Secured password " + password);
		
		shopOwnerDaoImpl.saveShopOwner(tempShopOwner);
		
	}
	
	public String appendBeforePassword(String password, String appendValue) {
	
		return appendValue.concat(password);
		
		
	}
	


}
