package com.shopstack.dao.user;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.user.User;


/**
 * @author oluwatobi
 *
 */
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class UserDaoImplTest {

	@Autowired
	private UserDao userDao;

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
	public void getUsersFromTheDatabaseTest() {
		
		List<User> result = userDao.getUsers();
		
		assertEquals("john", result.get(0).getUsername());
		
		System.out.println(result.get(0).toString());
		
	}

}
