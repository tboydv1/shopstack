package com.shopstack.service.user;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.isA;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.dao.user.TokenRepository;
import com.shopstack.entities.user.User;
import com.shopstack.entities.user.VerificationToken;


@ContextConfiguration(locations = "classpath:/service-layer-context.xml")
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Autowired
	private TokenRepository tokenRepositoryImpl;
	
	@Autowired
	private UserService userServiceImpl;
	
	
	@Before
	public void setUp() throws Exception {
		
		userServiceImpl = mock(UserService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void generateUserVerificationTokenTest() {
		
		doNothing().when(userServiceImpl).createVerificationTokenForUser(isA(User.class), isA(String.class));
		userServiceImpl.createVerificationTokenForUser(new User(), "");
		
		verify(userServiceImpl , times(1));
		
	}
	
	@Test
	public void getUserVerificationTokenTest() {
		
		when(userServiceImpl.getUserVerificationToken("")).thenReturn(isA(VerificationToken.class));
		userServiceImpl.getUserVerificationToken("");
		
		verify(userServiceImpl, times(1));
		
	}

}
