/**
 * 
 */
package com.shopstack.dao.productcategory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.productcategory.ProductCategory;

/**
 * @author RAY-ABEL
 *
 */

@Sql(scripts= {"classpath:shopstack-create-db.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class ProductCategoryImplTest {
	
	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * 
	 */
	
	@Test
	public void addNewUserTest() {
		ProductCategory temp = new ProductCategory("drinks");
		productCategoryDao.saveUser(temp);
	}
	@Test
	public void getProductCategory() {
		
		
		productCategoryDao.getProductCategory();
		
		
		
		
	}
}
