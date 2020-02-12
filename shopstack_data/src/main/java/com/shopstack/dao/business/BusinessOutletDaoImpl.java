package com.shopstack.dao.business;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.business.BusinessOutlet;


/**
 * @author oluwatobi
 *
 */
@Repository
@Transactional
public class BusinessOutletDaoImpl implements BusinessOutletDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public BusinessOutlet findById(int outletId) {
		
		return sessionFactory.getCurrentSession().get(BusinessOutlet.class, outletId);
	}

}
