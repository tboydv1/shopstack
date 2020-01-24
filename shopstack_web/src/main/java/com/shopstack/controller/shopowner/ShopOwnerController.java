package com.shopstack.controller.shopowner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopOwnerController {

	
	@GetMapping("/shop-owner")
	public String showRegisterForm() {
		
		return "onboarding";
	}
	
//	@PostMapping("/shop-owner")
	
}
