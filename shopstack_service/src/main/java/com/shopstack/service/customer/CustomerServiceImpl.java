package com.shopstack.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.customer.CustomerDao;
import com.shopstack.entities.customer.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDaoImpl;
	
	public void addCustomer(Customer customerId) {
		
		customerDaoImpl.addCustomer(customerId);
		
	}

}
