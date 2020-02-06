package com.shopstack.dao.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.user.BusinessUser;
import com.shopstack.entities.user.VerificationToken;


/**
 * @author oluwatobi
 *
 */

@Sql(scripts= {"classpath:shopstack-create-db.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class BusinessUserDaoImplTest {

	@Autowired
	private BusinessUserDao userDaoImpl;
//	
//	@Autowired 
//	TokenRepository tokenRepo;

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

		BusinessUser tempUser = new BusinessUser("Oluwatobi", "Omotosho", "tboydv1@gmail.com",
				"070598584784", "testpass", 0);
		
		
		
		
		
	}
	
	@Test
	public void getUsersTest() {
		
		//add shop owner to the database
		addNewUserTest();
		
		List<BusinessUser> result = userDaoImpl.getUsers();
		
		assertThat(result.size(), is(2));
		
	}
	
	
	
	
	
	
}
