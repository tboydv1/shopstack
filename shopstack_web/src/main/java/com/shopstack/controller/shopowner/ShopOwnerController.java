package com.shopstack.controller.shopowner;


import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.shopstack.controller.event.OnRegistrationCompleteEvent;
import com.shopstack.entities.shopowner.ShopOwner;
import com.shopstack.entities.user.User;
import com.shopstack.entities.user.VerificationToken;
import com.shopstack.service.shopowner.ShopOwnerServiceImpl;
import com.shopstack.service.user.UserService;

@Controller
@RequestMapping("/shop-owner")
public class ShopOwnerController {

	Logger logger = Logger.getLogger(ShopOwnerController.class.getName());
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private ShopOwnerServiceImpl shopOwnerServiceImpl;
	
	@Autowired
	private UserService userServiceImpl;
	
	@Autowired
	private MessageSource messages;
	

	
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
			BindingResult ownerBindingResult, 
				@Valid @ModelAttribute("user") User newUser, 
				BindingResult userBindingResult, WebRequest request, Model model) {
		
		logger.info("New shop owner form entry" + theShopOwner);
		logger.info("Validating binding result");
		
		if(ownerBindingResult.hasErrors() && userBindingResult.hasErrors()) {
			
			return "onboarding";
		}

		theShopOwner.setUserDetail(newUser);
		newUser.setShopOwner(theShopOwner);
		
		System.out.println(theShopOwner);
		System.out.println(theShopOwner.getUserDetail());
		
		
		//check if user email already exist
		ShopOwner registered = 	shopOwnerServiceImpl.addShopOwner(theShopOwner);
		
		if(registered == null) {
			
			model.addAttribute("error","There is already an account with this email: " + theShopOwner.getEmail());
			logger.info("Email already exists");
			
			return "onboarding";
			
		}else {
			
			try {
				String appUrl = request.getContextPath();
				logger.info("context path is: "+appUrl);
				eventPublisher.publishEvent(new 
						OnRegistrationCompleteEvent(registered.getUserDetail(), 
										request.getLocale(), appUrl));
			}catch(Exception EventExcepton) {
				
				EventExcepton.printStackTrace();
				
			}
			
			return "confirmation";
		}
		
	
		
	}
	
	@GetMapping("/confirm")
	public String showSuccessPage() {
		
		
		
		return "confirmation";
	}
	
	@GetMapping("/registrationConfirm")
	public String confirmRegistration(WebRequest request, Model model, 
			@RequestParam("token") String token) {
		
		Locale locale = request.getLocale();
		
		VerificationToken verificationToken = userServiceImpl.getVerificationToken(token);
		
		if(verificationToken == null) {
			String message = messages.getMessage("auth.messsage.invalidToken", null, locale);
			model.addAttribute("message", message);
			
			return "redirect:/confirm-failed?lang="+locale.getLanguage();
		}
		
		User user = verificationToken.getUser();
		Calendar cal = Calendar.getInstance();
		
		if((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			
			String message = messages.getMessage("auth.messsage.invalidToken", null, locale);
			model.addAttribute("message", message);
			
			return "redirect:/confirm-failed?lang="+locale.getLanguage();
		}
		
		user.setEnabled(1);
		userServiceImpl.saveRegisteredUser(user);
	    return "redirect:/login?lang=" + request.getLocale().getLanguage(); 
	}
	
	@GetMapping("/dashboard")
	public String showDashBoard() {
		
		return "dashboard";
	}
	
	
	
}
