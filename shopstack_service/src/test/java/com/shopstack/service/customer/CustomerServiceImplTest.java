package com.shopstack.service.customer;





import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.dao.customer.CustomerDao;
import com.shopstack.entities.customer.Customer;


@ContextConfiguration("classpath:/service-layer-context.xml")
@RunWith(SpringRunner.class)
class CustomerServiceImplTest {
	
	private Logger logger = Logger.getLogger( CustomerServiceImplTest.class);
	
	@Mock
	private CustomerService customerServiceImpl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		customerServiceImpl = mock(CustomerService.class);
	}

	@Test
	public void  cutomerServiceDaoInitializeTest() {
		logger.info("creating object");
		assertNotNull(customerServiceImpl);
	}
	
	@Test
 public void  cutomerExistInDatabaseTest() {
		
		try {
			Customer customer = new Customer("Peter","Brand@gmail","adejola Venture", 2312);
			 
			doNothing().when(customerServiceImpl).addCustomer(isA(Customer.class));
			
			customerServiceImpl.addCustomer(customer);
			
			verify(customerServiceImpl, times(1)).addCustomer(customer);
			
			}
		catch(Exception e) {
			logger.info("Error connecting to database");
			e.printStackTrace();
		}
		
	}
}
