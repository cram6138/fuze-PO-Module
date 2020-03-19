package com.fuze.po.PurchaseOrderAppUI.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuze.po.PurchaseOrderAppUI.auth.User;
import com.fuze.po.PurchaseOrderAppUI.auth.UserCredential;
import com.fuze.po.PurchaseOrderAppUI.auth.UserInfo;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PurchaseOrderController {

	@GetMapping("/welcome")
	public String welcomePage(Model model) {

		model.addAttribute("Welcome", "active");
		return "Welcome";
	}

	@GetMapping("/templtes")
	public String getTemplateList(Model model) {
		model.addAttribute("template", "active");
		return "template";
	}

	@GetMapping("/")
	public String firstPage(Model model) {
		model.addAttribute("login", "active");
		model.addAttribute("loginForm", new UserCredential());
		return "login";
	}

	@GetMapping("/index")
	public String WelcomePage(Model model, HttpServletRequest request) {
		model.addAttribute("index", "active");
		// Object obj = (UserInfo)request.getSession().getAttribute("currentUserInfo");
		return "index";
	}

	@RequestMapping("/PORequest")
	public String porequest(Model model) {
		model.addAttribute("PORequest", "active");
		return "PORequest";
	}

	@RequestMapping("/POTracker")
	public String potracker(Model model) {
		model.addAttribute("POTracker", "active");
		return "POTracker";
	}

	@RequestMapping("/POViewCart")
	public String poviewcart(Model model) {
		model.addAttribute("POViewCart", "active");
		return "POViewCart";
	}

	@RequestMapping("/reports")
	public String viewReports(Model model) {
		model.addAttribute("POViewCart", "active");
		return "reports";
	}

	@RequestMapping("/reservations")
	public String viewReservations(Model model, HttpServletRequest request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		model.addAttribute("container", "active");
		model.addAttribute("currentUserInfo",
				mapper.writeValueAsString((UserInfo) request.getSession().getAttribute("currentUserInfo")));
		return "reservations";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		System.out.println(request.getSession());
		return "redirect:/";
	}

	@GetMapping("/container")
	public String viewContainer(Model model, HttpServletRequest request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		model.addAttribute("container", "active");
		model.addAttribute("currentUserInfo",
				mapper.writeValueAsString((UserInfo) request.getSession().getAttribute("currentUserInfo")));
		return "container";
	}

}
