package com.shopstack.dao.shopowner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.shopowner.ShopOwner;


@Repository
public class ShopOwnerDaoImp implements  ShopOwnerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(ShopOwnerDao.class);
	
	
	@Transactional
	public void addShopOwner(ShopOwner shopOwner) {
		
		
		logger.info("it works");
		Session currentSession = sessionFactory.getCurrentSession();
		
		logger.info("Saving ShopOwner to database " + shopOwner.toString());
		
		currentSession.save(shopOwner);
	}

}
