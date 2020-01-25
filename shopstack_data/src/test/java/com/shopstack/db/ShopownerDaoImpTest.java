package com.shopstack.db;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

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
import com.shopstack.entities.shopowner.Shopowner;
import com.shopstack.shopownerDao.ShopOwnerDao;
import com.shopstack.shopownerDao.ShopOwnerDaoImp;
import com.sun.istack.logging.Logger;

@ContextConfiguration(locations = "classpath:/data-access-layer-context.xml")
@RunWith(SpringRunner.class)
public class ShopownerDaoImpTest {
	
	private Logger logger = Logger.getLogger(ShopOwnerDaoImp.class);
	
	
	@Autowired
	private ShopOwnerDao shopownerDaoImp;
	
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
//			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con= DriverManager.getConnection(jdbcUrl, username, password);
			
			queryRunner.update("drop database shopstack");
			
			queryRunner.update("create database shopstack");
		
			queryRunner.update("use shopstack");
			
			queryRunner.update("CREATE TABLE IF NOT EXISTS `shopstack`.`shop_owner` (\r\n" + 
					"  `shop_owner_id` INT(11) NOT NULL AUTO_INCREMENT,\r\n" + 
					"  `first_name` VARCHAR(45) NOT NULL,\r\n" + 
					"  `last_name` VARCHAR(45) NOT NULL,\r\n" + 
					"  `address` VARCHAR(45) NULL,\r\n" + 
					"  `email` VARCHAR(45) NOT NULL,\r\n" + 
					"  `contact_number` INT(45) NOT NULL,\r\n" + 
					"  `role` VARCHAR(45) NULL,\r\n" + 
					"  `username` VARCHAR(45) NOT NULL,\r\n" + 
					"  `password` VARCHAR(45) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`shop_owner_id`))\r\n" + 
					"ENGINE = InnoDB\r\n" + 
					"DEFAULT CHARACTER SET = latin1;");
			
		}
		catch(Exception e) {
			logger.warning("setUp() method", e.getCause());
			
			e.printStackTrace();
		}
		finally {
			
			DbUtils.close(con);
		}
		
}
	@Test
	public void dbManagerClassesInitializedTest() {
		
		logger.info("The object is not null");
		assertNotNull(shopownerDaoImp);
		assertNotNull(dataSource);

	}
	
	@Test
	public void addShoponwerToDatabaseTest() {
		
	try {	
		
		
		logger.info("Creating new ShopOwner object");
			 logger.info("Creating new ShopOwner object");
			Shopowner shopowner = new Shopowner("John", "Paulina", "john@gmail.com", 23362, "no 1 ajenifuja street", "assistant marketer");
			
			logger.info("Storing shopowner to the database");
		shopownerDaoImp.addShopOwner(shopowner);
			
			logger.info("Successfully saving shopowner to the databsase");
	
	}
	catch(Exception e) {
	
		e.printStackTrace();
		logger.warning("Error saving shopowner to the dataabse");
	}
	}
	
}
