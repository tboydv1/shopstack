package com.shopstack.controller.businessuser;

import java.util.Locale;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.icu.util.Calendar;
import com.shopstack.controller.event.OnRegistrationCompleteEvent;
import com.shopstack.entities.businessuser.BusinessUser;
import com.shopstack.entities.businessuser.VerificationToken;
import com.shopstack.service.businessuser.BussinessUserService;

@Controller
@RequestMapping("/user")
public class BusinessUserController {

	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private BussinessUserService businessUserServiceImpl;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		
		model.addAttribute("user", new BusinessUser());
		return "user-register-page";
	}
	
	@GetMapping("/process")
	public ModelAndView processRegistration(WebRequest request, 
			@ModelAttribute("user") @Valid BusinessUser businessUser, 
			BindingResult resultBinder, Errors errors) {
		
		System.out.println("New Request -->> " + businessUser);
		
		BusinessUser registered = new BusinessUser();
		
		
		if(resultBinder.hasErrors()) {
			System.out.println("Requst has errors");
			return new ModelAndView("register-page", "user", new BusinessUser());
		}
		

		registered = createUserAccount(businessUser, resultBinder);

		
		if(registered == null) {
			System.out.println("Email already exist");
			resultBinder.rejectValue("email", "message.regError");
		}
		try {
			String appUrl = request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent
					(businessUser, request.getLocale(), appUrl));
		}catch(RuntimeException runtime) {
				
			runtime.printStackTrace();
			return new ModelAndView("emailError", "user", new BusinessUser());
		}
		
		
		
		return new ModelAndView("confirmation","user_email", registered.getEmail());
	}
	
	@GetMapping("/confirm")
	public String confirmRegistration(WebRequest request, Model model, 
			@RequestParam("token") String token) {
		
		Locale locale = request.getLocale();
		
		VerificationToken savedToken = businessUserServiceImpl.getUserVerificationToken(token);
		if(savedToken == null) {
			model.addAttribute("user","invalid user");
			return "user-expired";
		}
		
		BusinessUser existingUser = savedToken.getUser();
		Calendar cal = Calendar.getInstance();
		
		if(savedToken.getExpiryDate().getTime() - cal.getTime().getTime() <= 0) {
			model.addAttribute("user", "user is expired");
			return "user-expired";
		}
		
		existingUser.setEnabled(1);
		businessUserServiceImpl.activateUser(existingUser);
		
		return "login";
	}
	
	
	private BusinessUser createUserAccount(BusinessUser businessUser, BindingResult result) {
		
	    BusinessUser registered = null;
	    try {
	        registered = businessUserServiceImpl.registerNewUserAccount(businessUser, "ROLE_ADMIN");
	        
	    } catch (Exception e) {
	    	
	        return null;
	    }
	    return registered;
	}
}
