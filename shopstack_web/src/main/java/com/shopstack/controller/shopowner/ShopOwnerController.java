package com.shopstack.controller.shopowner;


import java.util.logging.Logger;

import javax.validation.Valid;

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

import com.shopstack.entities.shopowner.ShopOwner;
import com.shopstack.service.shopowner.ShopOwnerServiceImpl;

@Controller
public class ShopOwnerController {

	Logger logger = Logger.getLogger(ShopOwnerController.class.getName());
	
	@Autowired
	private ShopOwnerServiceImpl shopOwnerServiceImpl;
	
	
	//add an initbinder... to convert trim input strings
	//remove leading and trailing whitespace
	//resolve validation issue
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		//apply stringtrimmer to string data
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/shop-owner")
	public String showRegisterForm(Model theModel) {
		
//		theModel.addAttribute("shopOwner", new ShopOwner());
		
		return "onboarding";
	}
	
	@PostMapping("/shop-owner")
	public String saveShopOwner(
			@Valid @ModelAttribute("shopOwner") ShopOwner theShopOwner,
			BindingResult theBindingResult) {
		
		logger.info("New shop owner form entry" + theShopOwner);
		
		logger.info("Validating binding result");
		
		if(theBindingResult.hasErrors()) {
			
			return "onboarding";
		}
		else {
			
			logger.info("calling the shopOwnerService.addShopOwner method");
			
			shopOwnerServiceImpl.addShopOwner(theShopOwner);

			return "confirmation";
		}
		
	}
	
	@GetMapping("/success")
	public String showSuccessPage() {
		
		return "confirmation";
	}
	
	
	
}
