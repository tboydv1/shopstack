package com.shopstack.controller.shopowner;


import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopstack.entities.shopowner.ShopOwner;
import com.shopstack.entities.user.User;
import com.shopstack.service.shopowner.ShopOwnerServiceImpl;

@Controller
@RequestMapping("/shop-owner")
public class ShopOwnerController {

	Logger logger = Logger.getLogger(ShopOwnerController.class.getName());
	
	@Autowired
	private ShopOwnerServiceImpl shopOwnerServiceImpl;

	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		//apply stringtrimmer to string data
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/register")
	public String showRegisterForm(ModelMap theModelMap) {
		
		theModelMap.addAttribute("user", new User());
		theModelMap.addAttribute("shopOwner", new ShopOwner());

		return "onboarding";
	}
	
	@GetMapping("/process")
	public String saveShopOwner(
			@Valid @ModelAttribute("shopOwner") ShopOwner theShopOwner,
			BindingResult theBindingResult, 
				@Valid @ModelAttribute("user") User newUser, 
				BindingResult userBindingResult) {
		
		logger.info("New shop owner form entry" + theShopOwner);
		
		logger.info("Validating binding result");
		
		if(theBindingResult.hasErrors() && userBindingResult.hasErrors()) {
			
			return "onboarding";
		}
		else {
			
			logger.info("Calling the shop owner service implementation");
			
			logger.info("New shop owner entry: "+theShopOwner+"/nWith user details: "+newUser);
			
			//set shop owner details
			theShopOwner.setUserDetail(newUser);
			
			shopOwnerServiceImpl.addShopOwner(theShopOwner);

			return "confirmation";
		}
		
	}
	
	@GetMapping("/confirm")
	public String showSuccessPage() {
		
		return "confirmation";
	}
	
	@GetMapping("/dashboard")
	public String showDashBoard() {
		
		return "dashboard";
	}
	
	
	
}
