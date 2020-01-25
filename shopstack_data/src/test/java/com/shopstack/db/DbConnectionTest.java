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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author adefunmi90
 *
 */
@ContextConfiguration("classpath:/data-access-layer-context.xml")
@RunWith(SpringRunner.class)
public class DbConnectionTest {
	
	
	private Logger logger = Logger.getLogger("DbConnectionTest");
	
	@Autowired
	private ComboPooledDataSource dataSource;
	 
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
	public void dataSourceInitializationTest() {
		assertNotNull(dataSource);
	}
	@Test
	public void dbConnectionManegerExistTest() {
		
		String user = "shopstack_admin";
		String password = "shopStack1.0";
		String jdbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&amp;serverTimezone=UTC";
		
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
