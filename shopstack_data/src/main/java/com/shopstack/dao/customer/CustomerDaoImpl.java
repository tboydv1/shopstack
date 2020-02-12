package com.shopstack.dao.customer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.customer.Customer;

/**
 * @author adefunmi
 *
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(CustomerDao.class);
	

@Override
public void addCustomer(Customer customerId) {
		

	Session currentSession = sessionFactory.getCurrentSession();
	logger.info("Saving Customer to database " + customerId.toString());
	
	currentSession.save(customerId);
	 
	
	}


	

}
