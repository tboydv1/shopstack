package com.shopstack.dao.authority;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.autorities.Authority;

@Repository
@Transactional	
public class AuthorityDaoImpl implements AuthorityDao {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	private Session currentSession;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Authority theUser) {
		
		try {
			logger.info("get current session");
			
			currentSession = sessionFactory.getCurrentSession();
			
		}
		catch(Exception exe) {
			logger.log(Level.SEVERE, "Execption thrown while getting current session" , exe);
		}
		
		try {
		
			currentSession.saveOrUpdate(theUser);
			
		}
		catch(Exception exe) {
			logger.log(Level.SEVERE, "Exeception thrown while executing query" , exe);

		}
		
		
	}

}
