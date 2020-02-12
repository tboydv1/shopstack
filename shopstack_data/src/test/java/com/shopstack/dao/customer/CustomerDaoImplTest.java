package com.shopstack.dao.customer;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.shopstack.dao.customer.CustomerDao;
import com.shopstack.entities.customer.Customer;

@ContextConfiguration("classpath:/data-access-layer-context.xml")
@RunWith(SpringRunner.class)
public class CustomerDaoImplTest {
	
	private Logger logger = Logger.getLogger(CustomerDaoImplTest.class.getName());

		@Autowired
		private CustomerDao customerDaoImpl;
		
		
		@Autowired
		private ComboPooledDataSource dataSource;
	
	@Before
	public void setUp() throws Exception {
		String user = "shopstack_admin";
		String password = "shopStack1.0";
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		String DBbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&serverTimezone=UTC";
		
		Connection connect  = null;
		
		
		QueryRunner queryRunner = new QueryRunner(dataSource);
	try {
		
		DbUtils.loadDriver(jdbcDriver);
		
		connect = DriverManager.getConnection(DBbcUrl,user, password);
	
		queryRunner.update("drop database shopstack_admin");
		
		queryRunner.update("create database shopstack_admin");
		
		queryRunner.update("use shopstack_admin");
		
		queryRunner.update("CREATE TABLE IF NOT EXISTS `shopstack`.`customer` (\r\n" + 
				"  `customer_id` INT(11) NOT NULL,\r\n" + 
				"  `name` VARCHAR(45) NOT NULL,\r\n" + 
				"  `email` VARCHAR(45) NOT NULL,\r\n" + 
				"  `organization_name` VARCHAR(45) NULL DEFAULT NULL,\r\n" + 
				"  `contact_number` INT(11) NOT NULL,\r\n" + 
				"  PRIMARY KEY (`customer_id`))\r\n" + 
				"ENGINE = InnoDB\r\n" + 
				"DEFAULT CHARACTER SET = latin1");
	}
	catch(Exception e) {
		logger.warn("setUp() method", e.getCause());
		e.printStackTrace();
	}
	finally {
		
		DbUtils.close(connect);
	}
	
	
	}

	@Test
	public void dbInitializingDataSourceTest() {
		logger.info("The object is not null");
		
		assertNotNull(customerDaoImpl);
		assertNotNull(dataSource);
		
	}
	@Test
	public void addCustomerToDatabaseTest() {
		try {
			logger.info("Create new customer");
			Customer customerId = new Customer("adewale","Brandy Nigeria Limited", "ajayibenson@gmail.com",672 );
			
			customerDaoImpl.addCustomer(customerId);
			logger.info("Successfully saved customer to the database");
			}
			
			catch(Exception e) {
				e.printStackTrace();
				logger.warn("Error saving customer to the database");
			
			}
	}
}
