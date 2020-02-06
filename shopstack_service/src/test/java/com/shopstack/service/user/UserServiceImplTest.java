package com.shopstack.service.user;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.entities.user.BusinessUser;
import com.shopstack.entities.user.VerificationToken;


@ContextConfiguration(locations = "classpath:/service-layer-context.xml")
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	
	
	
	@Mock
	private BussinessUserService userServiceImpl;
	
	
	@Before
	public void setUp() throws Exception {
		
		userServiceImpl = mock(BussinessUserService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	

}
