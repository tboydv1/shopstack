package com.shopstack.dao.businessuser;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopstack.entities.businessuser.VerificationToken;

@Repository
public class TokenDaoImpl implements TokenDao{

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveToken(VerificationToken newToken) {
		
		sessionFactory.getCurrentSession().save(newToken);
		
	}

	@Override
	public VerificationToken findByToken(String savedToken) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("from VerificationToken v where v.token = : savedToken");
		query.setParameter("savedToken", savedToken);
		try {
			return (VerificationToken) query.getResultList().get(0);
		}catch(RuntimeException Exception) {
			logger.info("Exception thrown while retrieving token from the database");
			return null;
		}
	}

	
}
