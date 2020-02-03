package com.shopstack.dao.user;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopstack.entities.user.VerificationToken;

@Repository
@Transactional
public class TokenRepositoryImpl implements TokenRepository {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void save(VerificationToken userToken) {
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			
			currentSession.save(userToken);
			}
		catch(Exception exe) {
			logger.log(Level.FATAL, "Exception thrown while saving to the database");
			exe.printStackTrace();
		}
	}


	@Override
	public VerificationToken findByToken(String token) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from VerificationToken v where v.token =: userToken");
		
		query.setParameter("userToken", token);
		
		VerificationToken result = (VerificationToken) query.getResultList();
		
		return result;
	}

}
