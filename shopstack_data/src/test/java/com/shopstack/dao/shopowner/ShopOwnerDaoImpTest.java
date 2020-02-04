package com.shopstack.dao.shopowner;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.shopowner.ShopOwner;
import com.shopstack.entities.user.User;


/**
 * @author oluwatobi
 *
 */
@Sql(scripts={"classpath:shopstack-create-db.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class ShopOwnerDaoImpTest {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Autowired
	private ShopOwnerDao shopOwnerDaoImp;
	
	
	@Before
	public void setUp() throws Exception {
		
     
	}

	@Test
	public void initializationTest() {
		
		assertNotNull(shopOwnerDaoImp);
	}
	
	@Test
	public void dbManagerClassesInitializedTest() {
		
		logger.info("Testing that Classes under test are properlly initialized");
		assertNotNull(shopOwnerDaoImp);
	

	}

	@Test
	public void addNewShopOwner() {
		
		//persist shop owners to the database
		logger.info("Persist shop owner objects to the database test!");
		
	try {
		
		ShopOwner tempShopOwner1 =  new ShopOwner("Simeon", "ocean", "743 round street",
				"simeon@mail.com", "070746536653");
		
		User username1 = new User("simeon", "test123", 1, "ROLE_MANAGER");
		
		tempShopOwner1.setUserDetail(username1);
		
		shopOwnerDaoImp.saveShopOwner(tempShopOwner1);
		
		//retrieve entity from database
		tempShopOwner1 = shopOwnerDaoImp.findByEmail("simeon@mail.com");
		
		assertThat(tempShopOwner1, is(not(nullValue())));
		assertThat(tempShopOwner1.getUserDetail(), is(not(nullValue())));
		assertThat(tempShopOwner1.getFirstName(), is("Simeon"));
		
				
		ShopOwner tempShopOwner2 =  new ShopOwner("Tobi", "Tosho", "743 round street",
				"tboydv1@gmail.com", "070746536653");
		
		
		User username2 = new User("tobi", "test123", 1, "ROLE_MANAGER");
		tempShopOwner2.setUserDetail(username2);
		
		shopOwnerDaoImp.saveShopOwner(tempShopOwner2);
		
		tempShopOwner2 = shopOwnerDaoImp.findByEmail("tboydv1@gmail.com");
		
		assertThat(tempShopOwner2, is(not(nullValue())));
		assertThat(tempShopOwner2.getUserDetail(), is(not(nullValue())));
		assertThat(tempShopOwner2.getFirstName(), is("Tobi"));
		
		
	}
	catch(Exception exe) {
		
		logger.throwing(getClass().getName(), " addNewShopOwner_cascadeSave_username_password() ", exe);
		exe.printStackTrace();
	}
	}
		
	@Test
	public void getAllShopOwnersFromTheDatabase() {
		
		//add shop owners to the database
		addNewShopOwner();
		
		List<ShopOwner> resultList = shopOwnerDaoImp.getShopOwners();
		assertTrue(resultList.size() == 2);
		
		
	}
	
	@Test
	public void findShopOwnerByEmail() {
		
		//add shop owners to the database
		addNewShopOwner();
		
		ShopOwner theShopOwner = shopOwnerDaoImp.findByEmail("tboydv1@gmail.com");
		
		assertThat(theShopOwner, is(not(nullValue())));
		
		assertThat(theShopOwner.getFirstName(), is("Tobi"));
		
		assertThat(theShopOwner.getUserDetail().getUsername(), is("tobi"));
		

	}
	
	@Test
	public void findShopOwnerNotExistingTest() {
		
		ShopOwner result = shopOwnerDaoImp.findByEmail("tboydv1@gmail.com");
		
		assertNull(result);
		
	}
	
	
	
	
	
	
		
		
		
	
	
	
}
