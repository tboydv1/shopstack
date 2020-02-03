package com.shopstack.dao.shopowner;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.shopowner.ShopOwner;



/**
 * @author oluwatobi
 *
 */
@Repository
@Transactional
public class ShopOwnerDaoImp implements  ShopOwnerDao {

	private Logger logger = Logger.getLogger(ShopOwnerDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	Session currentSession;
	
	@Override
	public void saveShopOwner(ShopOwner shopOwner) {
		// TODO Auto-generated method stub
		
		try {
			logger.info("getting current session");
			currentSession = getCurrentSession();
			
			logger.info("Saving shop owner to the database >>" + shopOwner);
			currentSession.save(shopOwner);
			
		}catch(Exception exe) {
			logger.error("Exception thrown while saving shopowner to the database");
			exe.printStackTrace();
			
		}
	
	}

	@Override
	public List<ShopOwner> getShopOwners() {
		// TODO Auto-generated method stub
		List<ShopOwner> resultList = null;
		
		try {
			logger.info("Getting shop owners from database");
			currentSession = getCurrentSession();
			
			Query<ShopOwner> theQuery = currentSession.createQuery("from ShopOwner", ShopOwner.class);
			
			resultList = theQuery.getResultList();
			
		}catch(Exception exe) {
			logger.error("Exception thrown while saving shopowner to the database");
			exe.printStackTrace();
		}
		
		return resultList;
		
	}
	
	public Session getCurrentSession() {
		
		Session sessionObj;
		
		try {
			sessionObj = sessionFactory.getCurrentSession();
		}
		catch(Exception exe) {
			
			
			logger.error("Exception thrown while getting current session");
			
			throw(exe);
		}
		
		return sessionObj;
	}

	@Override
	public List<ShopOwner> findByEmail(String email) {
		
		currentSession = getCurrentSession();
		
		Query query = currentSession.createQuery("from ShopOwner s where s.email = :userEmail");
		
		query.setParameter("userEmail", email);
		
		List<ShopOwner> resultList = query.getResultList();
		
		if(resultList.isEmpty()) {
			
			return null;
		}
		else {
			return resultList;
		}
		
		
	}
	
	

}
