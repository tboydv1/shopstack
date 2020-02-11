package com.shopstack.dao.business;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.business.Business;

@Repository
@Transactional
public class BusinessDaoImpl implements BusinessDao {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveBusiness(Business theBusiness) {
		
		Session currentSession = getCurrentSession();
		
		currentSession.save(theBusiness);
		
		
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




	@Override
	public void deleteBusiness(int businessId) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateBusiness() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	


	
}
