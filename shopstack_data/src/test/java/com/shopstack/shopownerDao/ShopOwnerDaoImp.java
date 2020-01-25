package com.shopstack.shopownerDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.shopowner.Shopowner;


@Repository
public class ShopOwnerDaoImp implements  ShopOwnerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(ShopOwnerDao.class);
	
	
	@Transactional
	public void addShopOwner(Shopowner shopowner) {
		
		
		logger.info("it works");
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("Saving ShopOwner to database " + shopowner.toString());
		
		currentSession.save(shopowner);
	}

}
