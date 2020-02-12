package com.shopstack.dao.business;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.business.BusinessCategory;

@Repository
@Transactional
public class BusinessCategoryDaoImpl implements BusinessCategoryDao {

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<BusinessCategory> getCategories() {
		
		List<BusinessCategory> resultList;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			
			Query<BusinessCategory> query = currentSession.createQuery("from BusinessCategory", BusinessCategory.class);
			
			resultList = query.getResultList();
			
		} catch(RuntimeException ex) {
			
			logger.info("Exception was thrown "+ ex.toString());
			
			ex.printStackTrace();
			resultList=null;
		}
		
		return resultList;
	}

}
