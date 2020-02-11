package com.shopstack.service.shopowner;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.shopowner.ShopOwnerDao;
import com.shopstack.entities.shopowner.ShopOwner;


@Service
public class ShopOwnerServiceImpl implements ShopOwnerService {

	
	private Logger logger = Logger.getLogger(ShopOwnerServiceImpl.class.getName());
	
	@Autowired
	private ShopOwnerDao shopOwnerDaoImpl;

	@Override
	public void addShopOwner(ShopOwner tempShopOwner) {
		
		logger.info("Calling shopOwnerDaoImpl.addShopOwer");
		
		shopOwnerDaoImpl.saveShopOwner(tempShopOwner);
		
	}
	


}
