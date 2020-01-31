package com.shopstack.controller.shopowner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "home";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
			
		return "login";
		
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
	
		return "access-denied";
	}
	
	
	
}
