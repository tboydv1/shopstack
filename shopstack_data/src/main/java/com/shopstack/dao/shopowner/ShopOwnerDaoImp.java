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

			currentSession = getCurrentSession();

			currentSession.saveOrUpdate(shopOwner);
			
		}catch(Exception exe) {

			exe.printStackTrace();
			
		}
	
	}

	@Override
	public List<ShopOwner> getShopOwners() {
		// TODO Auto-generated method stub
		List<ShopOwner> resultList = null;
		
		try {

			currentSession = getCurrentSession();
			
			Query<ShopOwner> theQuery = currentSession.createQuery("from ShopOwner", ShopOwner.class);
			
			resultList = theQuery.getResultList();
			
		}catch(Exception exe) {

			exe.printStackTrace();
		}
		
		return resultList;
		
	}
	
	public Session getCurrentSession() {
		
		Session sessionObj = null;
		
		try {
			sessionObj = sessionFactory.getCurrentSession();
		}
		catch(Exception exe) {
			
			exe.printStackTrace();
			
		}
		
		return sessionObj;
	}

	@Override
	public ShopOwner findByEmail(String email) {
		
		currentSession = getCurrentSession();
		
		Query query = currentSession.createQuery("from ShopOwner s where s.email = :userEmail");
		
		query.setParameter("userEmail", email);
		
		ShopOwner result = (ShopOwner) query.getResultList().get(0);
				
		if(result == null) {
			
			return null;
		}
		else {
			return result;
		}
		
		
	}
	
	

}
