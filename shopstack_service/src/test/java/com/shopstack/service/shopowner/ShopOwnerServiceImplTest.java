package com.shopstack.service.shopowner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.dao.shopowner.ShopOwnerDaoImp;
import com.shopstack.entities.shopowner.ShopOwner;

@ContextConfiguration(locations = "classpath:/service-layer-context.xml")
@RunWith(SpringRunner.class)
public class ShopOwnerServiceImplTest {

	private Logger logger = Logger.getLogger(ShopOwnerDaoImp.class.getName());
	
	
	@Mock
	private ShopOwnerService shopOwnerServiceImpl;
	
	
	@Before
	public void setUp() throws Exception {
		
		shopOwnerServiceImpl = mock(ShopOwnerService.class);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void shopOwnerServiceImplExistTest() {
			
		assertNotNull(shopOwnerServiceImpl);
	}

	@Test
	public void addShopOwnerTest() {
		
		ShopOwner tempShopOwner =  new ShopOwner("John", "Black", "123 black street",
												"john@mail.com", "07053564537432", 
												"john", "john123");

		
		doNothing().when(shopOwnerServiceImpl).addShopOwner(isA(ShopOwner.class));
		shopOwnerServiceImpl.addShopOwner(tempShopOwner);
		
		verify(shopOwnerServiceImpl, times(1)).addShopOwner(tempShopOwner);
	}

}
