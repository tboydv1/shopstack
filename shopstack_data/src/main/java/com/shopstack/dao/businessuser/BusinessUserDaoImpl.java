package com.shopstack.dao.businessuser;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.businessuser.BusinessUser;


/**
 * @author oluwatobi
 *
 */
@Repository
@Transactional
public class BusinessUserDaoImpl implements BusinessUserDao{

	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;
	


	@Override
	public List<BusinessUser> getUsers() {
		
		List<BusinessUser> resultList = null;
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
		
			Query<BusinessUser> query = currentSession.createQuery("from User", BusinessUser.class);

			resultList = query.getResultList();
		}
		catch(Exception exe) {
			
			resultList = null;

		}
		
			return resultList;
			
	}

	@Override
	public void saveUser(BusinessUser theUser) {
			
		Session currentSession = sessionFactory.getCurrentSession();
		
		if(theUser != null)
			currentSession.saveOrUpdate(theUser);
		else 
			throw new NullPointerException();
		
		
	}



	@Override
	public BusinessUser loadUserById(int businessUserId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		BusinessUser existingUser = (BusinessUser) currentSession
												.get(BusinessUser.class.getName(), businessUserId);
	
		return existingUser;
		
	}

	@Override
	public BusinessUser loadUserByEmail(String email) {
			
		BusinessUser existingUser;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("from BusinessUser u where u.email =: bizEmail");
		
		query.setParameter("bizEmail", email);
		
		try {
			existingUser = (BusinessUser) query.getResultList().get(0);

		}catch(RuntimeException runtimeEx) {
			
			logger.warning("Runtime exception while fetching user from the database \n" + runtimeEx);
			existingUser = null;
		}
		
		return existingUser;
	}

	
	
	

	
	
	
}
