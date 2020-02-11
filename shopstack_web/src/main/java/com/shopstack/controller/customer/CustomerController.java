package com.shopstack.controller.customer;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopstack.entities.customer.Customer;
import com.shopstack.service.customer.CustomerServiceImpl;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	private Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl; 
	
	

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
	
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/form")
	public String showCustomeRegisterForm(Model myModel) {
		
	   myModel.addAttribute("customer", new Customer());
	   
		return "customer-form";
	}
   
   @GetMapping("/process")
	public String saveShopOwner(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		logger.info("New customer form" + theCustomer);
		logger.info("Validating binding result");
		
		if(theBindingResult.hasErrors()) {
			
			return "customer-form";
		}
		else {
			
			customerServiceImpl.addCustomer(theCustomer);

			return "success-form";
		}
   }
}
