package com.shopstack.entities.customer.Dao;



import java.text.DateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Locale;

import com.shopstack.entities.customer.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(CustomerDao.class);
	
	
@Transactional
public void addCustomer(Customer customerId) {
		
	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
	String formattedDate = dateFormat.format(date);

	Session currentSession = sessionFactory.getCurrentSession();
	logger.info("Saving Customer to database " + customerId.toString());
	
	currentSession.save(customerId);
	 
	currentSession.save(formattedDate);
	
	}


	

}
