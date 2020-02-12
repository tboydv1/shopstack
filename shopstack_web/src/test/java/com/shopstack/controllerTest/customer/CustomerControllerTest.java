package com.shopstack.controllerTest.customer;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.shopstack.controller.customer.CustomerController;
import com.shopstack.entities.customer.Customer;
import com.shopstack.service.customer.CustomerService;

@ContextConfiguration("file:src/main/webapp/WEB-INF/web-layer-context-servlet.xml ")
@RunWith(SpringRunner.class)
public class CustomerControllerTest {
	private Logger logger;
	private MockMvc mockMvc;
	
	
	@Mock
	private CustomerService customerserviceImpl;
 
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(CustomerController.class).build();
	}

	@Test
	public void getCustomerRequestFormTest() {
		assertNotNull(customerserviceImpl);
	}

	@Test
	public void addCustomer() throws Exception {
		try {
		Customer myCustomer = new Customer("Adelola", "adeola@gmail.com", "Fabtech Nigeria Limited", 324);
		doNothing().when(customerserviceImpl).addCustomer(isA(Customer.class));
		
		customerserviceImpl.addCustomer(myCustomer);
		
		verify(customerserviceImpl, times(1)).addCustomer(myCustomer);
		
		}
	
		catch(Exception e) {
			logger.info("Error connecting");
			e.printStackTrace();
	
	}
	}
}
