package com.shopstack.customerDb;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@ContextConfiguration("classpath:/data-access-layer-context.xml")
@RunWith(SpringRunner.class )
public class DbConnectionManegerCustomerTest {
	private Logger logger = Logger.getLogger( DbConnectionManegerCustomerTest.class);
	 
	@Autowired
	private ComboPooledDataSource dataSource;

	@Before
	public void setUp() throws Exception {
		
	}
	 
	
	@Test
	public void dataSourceInitializzationTest() {
		assertNotNull(dataSource);
		
	}
	
	@Test
	public void dbConnectionForustomerTest() {
		String user = "shopstack_admin";
		String password = "shopStack1.0";
		String jdbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&amp;serverTimezone=UTC";
		
		try {
			logger.info("Getting connection to database");
			Connection myCon= DriverManager.getConnection(jdbcUrl, user, password);
			
			assertNotNull(myCon);
			logger.info("Connection tto database successful! ");
		}
		catch(SQLException e) {
			logger.info("error connection to database");
		}
		
	}

}
