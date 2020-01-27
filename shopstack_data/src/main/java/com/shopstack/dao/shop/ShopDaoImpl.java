package com.shopstack.dao.shop;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.dao.shopowner.ShopOwnerDaoImp;
import com.shopstack.entities.shop.Shop;

public class ShopDaoImpl implements ShopDao {
	
	private Logger logger = Logger.getLogger(ShopDaoImpl.class.getName());

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addShop(Shop tempShop) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		logger.info("saving a shop to the database" + tempShop);
		
		currentSession.save(tempShop);
	}

	
}
