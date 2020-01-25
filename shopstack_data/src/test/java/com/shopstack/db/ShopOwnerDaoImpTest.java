package com.shopstack.db;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.shopstack.dao.shopowner.ShopOwnerDao;
import com.shopstack.dao.shopowner.ShopOwnerDaoImp;

import com.shopstack.entities.shopowner.ShopOwner;



@ContextConfiguration(locations = "classpath:/data-access-layer-context.xml")
@RunWith(SpringRunner.class)
public class ShopOwnerDaoImpTest {
	
	private Logger logger = Logger.getLogger(ShopOwnerDaoImp.class.getName());
	
	
	@Autowired
	private ShopOwnerDao shopOwnerDaoImp;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Before
	public void setUp() throws Exception {
		
		String username = "shopstack_admin";
		
		String password = "shopStack1.0";
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&serverTimezone=UTC";
		
		Connection con = null;
		
		QueryRunner queryRunner = new QueryRunner(dataSource);
		
		try {
			
			
			DbUtils.loadDriver(jdbcDriver);
			
			con= DriverManager.getConnection(jdbcUrl, username, password);
			
//			queryRunner.update("drop database shopstack");
//			
//			queryRunner.update("create database shopstack");
//		
//			queryRunner.update("use shopstack");
			
			
		}
		catch(Exception e) {
			
			logger.throwing(ShopOwnerDaoImpTest.class.getName(), "setUp() method", e.getCause());
			e.printStackTrace();
			
		}
		finally {
			
			DbUtils.close(con);
		}
		
}
	@Test
	public void dbManagerClassesInitializedTest() {
		
		logger.info("Testing that Classes under test are properlly initialized");
		assertNotNull(shopOwnerDaoImp);
		assertNotNull(dataSource);

	}
	
	@Test
	public void addShoponwerToDatabaseTest() {
		
	try {
		
		logger.info("Creating a shop owner object");
		ShopOwner tempShopOwner =  new ShopOwner("John", "Black", "123 black street", "john@mail.com", "07053564537432", "john", "john123");
		
		logger.info("Saving the a new Shop owner to the database");
		shopOwnerDaoImp.addShopOwner(tempShopOwner);

		logger.info("Successfully saved shopowner to the databsase");
	
	}
	catch(Exception e) {
	
		e.printStackTrace();
		logger.warning("Error saving shopowner to the dataabse");
	}
	}
	
}
