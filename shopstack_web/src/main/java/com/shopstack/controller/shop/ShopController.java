package com.shopstack.controller.shop;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopstack.dao.business.BusinessDao;
import com.shopstack.entities.business.Business;


/**
 * @author oluwatobi
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired	
	private BusinessDao shopDaoImpl;
	
	
	@GetMapping("/create")
	public String showFormToAddNewShop(Model model) {
		
		model.addAttribute("shop", new Business());
		return "shop-form";
	}
	
	@PostMapping("/process")
	public String saveShop(@Valid @ModelAttribute("shop")Business newShopEntry, BindingResult resultBind, Model model) {
		
		if(resultBind.hasErrors()) {
			model.addAttribute("error","error creating new shop");
			
			return "shop-form";
		}
		
		shopDaoImpl.saveBusiness(newShopEntry);
		
		return "redirect:/shop-owner/dashboard";
	}
}
