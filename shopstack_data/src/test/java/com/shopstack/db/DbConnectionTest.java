/**
 * 
 */
package com.shopstack.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;

/**
 * @author adefunmi90
 *
 */
@ContextConfiguration(classes = DataContextConfig.class)	
//@ContextConfiguration("classpath:/data-access-layer-context.xml")	
@RunWith(SpringRunner.class)
public class DbConnectionTest {
	
	
	private Logger logger = Logger.getLogger(getClass().getName());
	

	 
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void dbConnectionManegerExistTest() {
		
		String user = "shopstack_admin";
		String password = "shopStack1.0";
		String jdbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&serverTimezone=UTC";
		
		try {
			logger.info("Getting connection to database");
			Connection myConnect = DriverManager.getConnection(jdbcUrl, user, password);
			
			assertNotNull(myConnect);
			logger.info("Connection tto database successful! ");
		}
		catch(SQLException e) {
			logger.info("error connection to database");
		}
		
	}
}
