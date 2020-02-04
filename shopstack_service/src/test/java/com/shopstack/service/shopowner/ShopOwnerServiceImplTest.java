package com.shopstack.service.shopowner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.dao.shopowner.ShopOwnerDaoImp;
import com.shopstack.entities.shopowner.ShopOwner;
import com.shopstack.entities.user.User;

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
	public void addShopOwnListerTest() {
		
		User theUser = new User("john", "{noop}test", 1, "ROLE_MANAGER");
		ShopOwner tempShopOwner =  new ShopOwner("John", "Black", "123 black street",
												"john@mail.com", "07053564537432");
		tempShopOwner.setUserDetail(theUser);
		
		when(shopOwnerServiceImpl.addShopOwner(isA(ShopOwner.class))).thenReturn(tempShopOwner);
		tempShopOwner = shopOwnerServiceImpl.addShopOwner(tempShopOwner);
				
		verify(shopOwnerServiceImpl, times(1)).addShopOwner(tempShopOwner);

		
	}
	
	@Test
	public void findUserByEmail() {
		
		when(shopOwnerServiceImpl.findByEmail("tboydv1@gmail.com")).thenReturn(isA(ShopOwner.class));
		shopOwnerServiceImpl.findByEmail("tboydv1@gmail.com");
		
		verify(shopOwnerServiceImpl, times(1)).findByEmail("tboydv1@gmail.com");
		
	}
	
	
	


}
