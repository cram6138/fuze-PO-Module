package com.fuze.po.PurchaseOrderAppUI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseOrderController {

	@GetMapping("/welcome")
	public String welcomePage(Model model) {
		model.addAttribute("Welcome","active");
		return "Welcome";
	}
	
	@GetMapping("/templates")
	public String getTemplateList(Model model) {
		model.addAttribute("template","active");
		return "template";
	}
	
	@GetMapping("/")
	public String firstPage(Model model) {
		model.addAttribute("login","active");
		return "login";
	}
	@GetMapping("/index")
	public String WelcomePage(Model model) {
		model.addAttribute("index","active");
		return "index";
	}
	
	@RequestMapping("/PORequest")
	public String porequest(Model model) {
		model.addAttribute("PORequest","active");
		return "PORequest";
	}
	@RequestMapping("/POTracker")
	public String potracker(Model model) {
		model.addAttribute("POTracker","active");
		return "POTracker";
	}
	
}
