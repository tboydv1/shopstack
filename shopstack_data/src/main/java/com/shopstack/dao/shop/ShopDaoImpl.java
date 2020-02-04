package com.shopstack.dao.shop;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.shop.Shop;

@Repository
@Transactional
public class ShopDaoImpl implements ShopDao {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addShop(Shop tempShop) {
		
		Session currentSession = getCurrentSession();
		
		currentSession.save(tempShop);
		
		
	}

	@Override
	public void deleteShop(int shopId) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void updateShop() {
		// TODO Auto-generated method stub
		
		
		
		
	}

	@Override
	public List<Shop> getShops() {
			
		Session currentSession = getCurrentSession();
		
		Query query = currentSession.createQuery("from Shop");
		
		List<Shop> resultList = query.getResultList();
		
		return resultList;
	}
	
	public Session getCurrentSession() {
		Session currentSession = null;
		
		try {
			currentSession = sessionFactory.getCurrentSession();
		}
		catch(Exception exe) {
			
			logger.log(Level.SEVERE, "Exception thrown while getting current session");
		}
		
		return currentSession;
	}
	
	
	
	
	


	
}
