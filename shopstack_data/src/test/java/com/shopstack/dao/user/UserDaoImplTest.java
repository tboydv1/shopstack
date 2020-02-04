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
import com.shopstack.entities.user.User;


/**
 * @author oluwatobi
 *
 */

@Sql(scripts= {"classpath:shopstack-create-db.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class UserDaoImplTest {

	@Autowired
	private UserDao userDaoImpl;

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
//		
//		ShopOwner tempShopOwner1 =  new ShopOwner("Simeon", "ocean", "743 round street",
//				"simeon@mail.com", "070746536653");
//		
		User tempUser = new User("tobi","tobi123",1,"ROLE_USER");
		userDaoImpl.saveUser(tempUser);
		User savedUser = userDaoImpl.loadUserByUsername("tobi");
		assertThat(savedUser.getUsername(), is("tobi"));
		assertThat(savedUser.getPassword(), is("tobi123"));
		
		User tempUser2 = new User("Troy","troy123",1,"ROLE_USER");
		userDaoImpl.saveUser(tempUser2);
		User savedUser2 = userDaoImpl.loadUserByUsername("Troy");
		assertThat(savedUser2.getUsername(), is("Troy"));
		assertThat(savedUser2.getPassword(), is("troy123"));
		
		
	}
	
	@Test
	public void getUsersTest() {
		
		//add shop owner to the database
		addNewUserTest();
		
		List<User> result = userDaoImpl.getUsers();
		
		assertThat(result.size(), is(2));
		
	}
	
	@Test
	public void updateUserTest() {
		
		//add shop owner to the database
		addNewUserTest();
		
		User tempUser = userDaoImpl.loadUserByUsername("tobi");
		
		assertThat(tempUser.getEnabled(), is(1));
		//update permission
		tempUser.setEnabled(0);
		
		//persisit
		userDaoImpl.saveUser(tempUser);
		
		tempUser = userDaoImpl.loadUserByUsername("tobi");
		
		assertThat(tempUser.getEnabled(), is(0));
		
	
	}
	
	
	
	
	
}
