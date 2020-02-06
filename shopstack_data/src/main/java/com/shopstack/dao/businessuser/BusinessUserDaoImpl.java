package com.shopstack.dao.businessuser;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.user.BusinessUser;


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
		
			logger.info("getting list of users from the database");
			
			Query<BusinessUser> query = currentSession.createQuery("from User", BusinessUser.class);
			
			logger.info("Executing query");
			resultList = query.getResultList();
			
			logger.info(" >>> Successfully got users from database <<<<");
			
		}
		catch(Exception exe) {
			logger.log(Level.SEVERE, "Exeception thrown while executing query" , exe);

		}
		
			return resultList;
			
	}

	@Override
	public void saveUser(BusinessUser theUser) {
			
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
		
			currentSession.saveOrUpdate(theUser);
			
		}
		catch(Exception exe) {
			
			logger.log(Level.SEVERE, "Exeception thrown while executing query" , exe);

		}
		
		
	}



	@Override
	public BusinessUser loadUserByEmail(String email) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from User u where u.username = :text");
		
		query.setParameter("text", email);
		
		BusinessUser queryResult;
		
		try {
			queryResult = (BusinessUser) query.getResultList().get(0);
		}catch(Exception e) {
			queryResult = null;
		}
		
		return queryResult;
	}
	
	

	
	
	
}
