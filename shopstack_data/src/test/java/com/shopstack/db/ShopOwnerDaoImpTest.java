package com.shopstack.db;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

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
		
//		String username = "shopstack_admin";
//		
//		String password = "shopStack1.0";
//		
//		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
//		
//		String jdbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&serverTimezone=UTC";
//		
//		Connection con = null;
//		
////		QueryRunner queryRunner = new QueryRunner(dataSource);
//		
//		try {
//			
//			con = DriverManager.getConnection(jdbcUrl, username, password);
//			
//			ScriptRunner scr = new ScriptRunner(con);
//			
//			//get path of sql script from the classpath
//			Path Url =Paths.get(ClassLoader.getSystemResource("shopstack-create-db.sql").toURI());
//			
//			logger.info("Sql script path -->>" + Url.toString());
//			
//			//Read sql script from file
//			Reader reader = new BufferedReader(new FileReader(Url.toString()));
//			
//			//run the script
//			scr.runScript(reader);
//			
//			
//		}
//		catch(Exception e) {
//			
//			logger.throwing(ShopOwnerDaoImpTest.class.getName(), "setUp() method", e.getCause());
//			e.printStackTrace();
//			
//		}
//		finally {
//
//			logger.log(Level.INFO, "Closing the connection to the db");
//			con.close();
//		}
		
}
	
	@Test
	public void initializationTest() {
		
		assertNotNull(shopOwnerDaoImp);
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
		
		ShopOwner tempShopOwner =  new ShopOwner("John", "Black", "123 black street",
													"john@mail.com", "07053564537432", 
													"john", "john123");
		
		assertEquals("John", tempShopOwner.getFirstName());

		
		logger.info("Saving the a new Shop owner to the database");
		shopOwnerDaoImp.addShopOwner(tempShopOwner);

		logger.info("Successfully saved shopowner to the databsase");
	
	}
	catch(Exception e) {
	
		e.printStackTrace();
		logger.warning("Error saving shopowner to the dataabse");
	}
	}
	
	@Test
	public void invalidFirstNameArgumentTest() {
		
		
		try {
			ShopOwner tempShopOwner = new ShopOwner();
			
			tempShopOwner.setFirstName("");
			assertEquals("", tempShopOwner.getFirstName());
			
		}
		catch(Exception e) {
			
		}
	
		
		
	}
	
	
}
