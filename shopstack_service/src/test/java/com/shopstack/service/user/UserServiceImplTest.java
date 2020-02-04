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

import com.shopstack.dao.user.TokenRepository;
import com.shopstack.entities.user.User;
import com.shopstack.entities.user.VerificationToken;


@ContextConfiguration(locations = "classpath:/service-layer-context.xml")
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Autowired
	private TokenRepository tokenRepositoryImpl;
	
	@Mock
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
		
		User user = new User("tobi", "test123", 1, "ROLE_USER");
		doNothing().when(userServiceImpl).createVerificationTokenForUser(isA(User.class), isA(String.class));
		userServiceImpl.createVerificationTokenForUser(user, "");
		
		
		verify(userServiceImpl , times(1)).createVerificationTokenForUser(user, "");;
		
	}
	
	@Test
	public void getUserVerificationTokenTest() {
	
		
		when(userServiceImpl.getUserVerificationToken("")).thenReturn(isA(VerificationToken.class));
		userServiceImpl.getUserVerificationToken("");
		
		verify(userServiceImpl, times(1)).getUserVerificationToken("");
		
	}

}
