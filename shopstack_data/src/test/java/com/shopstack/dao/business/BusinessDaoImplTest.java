package com.shopstack.dao.business;

import static org.junit.Assert.*;

import java.util.List;

import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.dao.businessuser.BusinessUserDao;
import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessServiceType;
import com.shopstack.entities.user.BusinessUser;


@Sql(scripts= {"classpath:/db/shopstack-create-db.sql", "classpath:/db/business-category-insert.sql", "classpath:/db/insert-users.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class BusinessDaoImplTest {
	
	Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private BusinessUserDao businessUserDao;
	
	@Autowired
	private BusinessCategoryDao businessCategoryDaoImpl;
	
	@Autowired
	private BusinessServiceTypeDao businessServiceDaoImpl;
	
	@Autowired
	private BusinessDao businessDaoImpl;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void classesInitializedTest() {
		
		assertNotNull(businessCategoryDaoImpl);
		assertNotNull(businessServiceDaoImpl);
	}
	
	@Test
	public void getBusinessServiceTest() {
		
		List<BusinessServiceType> savedList = businessServiceDaoImpl.getBusinessServices(); 
		
		assertNotNull(savedList);
		
		for(BusinessServiceType value : savedList) {
			
			System.out.println(value.toString());
		}
		
		
	}
	

	@Test
	public void getBusinessCategories() {
		
		List<BusinessCategory> savedList = businessCategoryDaoImpl.getCategories(); 
		
		assertNotNull(savedList);
		
		for(BusinessCategory value : savedList) {
			
			System.out.println(value.toString());
		}
		
		
	}
	
	@Test
	public void saveNewBusinessTest() {
		
		BusinessUser businessUser = businessUserDao.loadUserByEmail("tosho@mail.com");
		assertNotNull(businessUser);
		
		List<BusinessCategory> categoryList = businessCategoryDaoImpl.getCategories(); 
		assertNotNull(categoryList);
		
		List<BusinessServiceType> servicesList = businessServiceDaoImpl.getBusinessServices(); 
		assertNotNull(servicesList);
		
		Business newBusiness = new Business("Shopify", "shopify@mybusiness.com", categoryList.get(2), servicesList.get(1), businessUser);
		
		businessDaoImpl.saveBusiness(newBusiness);
		

		
	}
	
	
	
	

}
