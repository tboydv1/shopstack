package com.shopstack.dao.shopowner;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.shopowner.ShopOwner;
import com.shopstack.entities.user.User;


/**
 * @author oluwatobi
 *
 */
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class ShopOwnerDaoImpTest {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Autowired
	private ShopOwnerDao shopOwnerDaoImp;
	
	@Before
	public void setUp() throws Exception {
		
//	  String user = "shopstack_admin";
//	  String password = "shopStack1.0";
//	  String jdbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&serverTimezone=UTC";
//	
//
//	  Connection myCon = DriverManager.getConnection(jdbcUrl, user, password);
//
//      //Initialize the script runner
//      ScriptRunner sr = new ScriptRunner(myCon);
//      //Creating a reader object
//      Reader reader = new BufferedReader(new FileReader("shopstack-create-db.sql"));
//      //Running the script
//      sr.runScript(reader);
      
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
	public void addNewShopOwner_cascadeSave_username_password() {
		
	
	try {
		User username = new User("funmi", "test123", 1);
		
		logger.info("creating user details" + username);
		
		ShopOwner tempShopOwner1 =  new ShopOwner("Funmi", "Oyeyipo", "908 bowan street",
				"green@mail.com", "07053564537432", username);
		
		shopOwnerDaoImp.saveShopOwner(tempShopOwner1);
		
		User username2 = new User("bleak", "test123", 1);
		
		ShopOwner tempShopOwner2 =  new ShopOwner("ray", "brook", "743 round street",
				"ray@mail.com", "070746536653", username2);
	
		shopOwnerDaoImp.saveShopOwner(tempShopOwner2);
		
		
	}
	catch(Exception exe) {
		
		logger.throwing(getClass().getName(), " addNewShopOwner_cascadeSave_username_password() ", exe);
	
	}
	}
		
	@Test
	public void getAllShopOwnersFromTheDatabase() {
		
		
		//get all shopowners saved in the database
		logger.info("Getting shopowners from the database");
		List<ShopOwner> result = shopOwnerDaoImp.getShopOwners();
		
		for(ShopOwner person: result) {
			
			logger.info(person.toString());
		}
		
	}
	
	
	
		
		
		
	
	
	
}
