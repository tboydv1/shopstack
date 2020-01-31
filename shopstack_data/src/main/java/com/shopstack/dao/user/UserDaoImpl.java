package com.shopstack.dao.user;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.user.User;


/**
 * @author oluwatobi
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private Session currentSession;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		
		List<User> resultList = null;
		
		try {
			logger.info("get current session");
			
			currentSession = sessionFactory.getCurrentSession();
			
		}
		catch(Exception exe) {
			logger.log(Level.SEVERE, "Execption thrown while getting current session" , exe);
		}
		
		try {
		
			logger.info("getting list of users from the database");
			
			Query<User> query = currentSession.createQuery("from User", User.class);
			
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
	public void saveUser(User theUser) {
		
		try {
			logger.info("get current session");
			
			currentSession = sessionFactory.getCurrentSession();
			
		}
		catch(Exception exe) {
			logger.log(Level.SEVERE, "Execption thrown while getting current session" , exe);
		}
		
		try {
		
			currentSession.save(theUser);
			
		}
		catch(Exception exe) {
			logger.log(Level.SEVERE, "Exeception thrown while executing query" , exe);

		}
		
		
	}

	
	
	
}
