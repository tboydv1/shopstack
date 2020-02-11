package com.shopstack.dao.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.user.BusinessUser;


/**
 * @author oluwatobi
 *
 */
@Repository
@Transactional
public class BusinessDaoImpl implements BusinessDao {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void saveBusiness(Business theBusiness) {
		
		Session currentSession = getCurrentSession();
		
		if(theBusiness != null)
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




	@Override
	public List<Business> getBusinessByOwner(BusinessUser businessUser) {
//		
//		List<Business> result = null;
//		
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		try {
//			
//			
//			CriteriaBuilder cr = currentSession.getCriteriaBuilder();
//			
//			cr.createQuery(Business.class).a
//			cr.and(Restrictions.eq("address.id", addressId))
//			query.setParameter("businessUser", businessUser.getUserId());
//			
//			result = query.getResultList();
//			
//			System.out.println("Query sucessfull for business with user id");
//			
//		}catch(Exception exe) {
//			System.out.println("Query exception for business with user id");
//			exe.printStackTrace();
//			result = null;
//		}
//		
		return null;
		
	}
	
	@Override
	public Business getBusinessByEmail(String bizEmail) {
		
	
		Business result = null;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			
			
			@SuppressWarnings("rawtypes")
			Query query = currentSession.createQuery("from Business b where b.bizEmail = :email");
			
			query.setParameter("email", bizEmail);
			
			result = (Business) query.getResultList().get(0);
			
			System.out.println("Query sucessfull for business with user id");
			
			
		}catch(Exception exe) {
			
			System.out.println("Query exception for business with user id");
			exe.printStackTrace();
			result = null;
			
		}
	
		
		return result;
		
	}

	@Override
	public Business getBusinessById(int businessId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Business.class, businessId);
	}
	
	
	
	
	


	
}
