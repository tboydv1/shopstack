package com.shopstack.dao.productcategory;




import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopstack.entities.productcategory.ProductCategory;

/**
 * @author RAY-ABEL
 *
 */
@Repository
@Transactional
public class ProductCategoryDaoImpl implements ProductCategoryDao {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUser(ProductCategory productCategory) {
    Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			
			if(productCategory != null)
				currentSession.saveOrUpdate(productCategory);
			
		}
		catch(Exception exe) {
			
			logger.log(Level.SEVERE, "Exeception thrown while executing query" , exe);

		}

	}

	@Override
	public List<ProductCategory> getProductCategory() {
		
		List<ProductCategory> resultList = null;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
		
			logger.info("get product from  database");
			
			Query<ProductCategory> query = currentSession.createQuery("from category", ProductCategory.class);
			
			logger.info("Executing query");
			resultList = query.getResultList();
			
			logger.info(" >>> Success <<<<");
			
		}
		catch(Exception exe) {
			logger.log(Level.SEVERE, "Exeception thrown while executing query" , exe);

		}
		
			return resultList;
			
	}
	
	}


