package com.shopstack.dao.businessuser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.role.Role;
import com.shopstack.entities.user.BusinessUser;




/**
 * @author oluwatobi
 *
 */

@Sql(scripts= {"classpath:shopstack-create-db.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class BusinessUserDaoImplTest {

	@Autowired
	private BusinessUserDao businessUserDaoImpl;
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
		
		Role userRole = new Role("ROLE_USER");

		BusinessUser tempUser = new BusinessUser("Oluwatobi", "Omotosho", "tboydv1@gmail.com",
				"070598584784", "testpass", 0, userRole);
		
		businessUserDaoImpl.saveUser(tempUser);
		
		BusinessUser savedUser = businessUserDaoImpl.loadUserByEmail(tempUser.getEmail());
		
		assertNotNull(savedUser);
		
		assertEquals(savedUser.getFirstName(), tempUser.getFirstName());
		
	
	}
	
	@Test
	public void addNullUserTest() {
		
		BusinessUser tempUser = null;
		
		assertThrows(NullPointerException.class,  ()-> businessUserDaoImpl.saveUser(tempUser));
		
	}
	
	
	
	
	
}
