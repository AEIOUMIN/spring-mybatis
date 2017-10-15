package com.boxy.showcase.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/validate")
	public String validate(HttpSession session, String username, String password){
		
		session.setAttribute("username", username);
		
		return "redirect:/student/index/1";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		
		return "redirect:/login";
	}
}
