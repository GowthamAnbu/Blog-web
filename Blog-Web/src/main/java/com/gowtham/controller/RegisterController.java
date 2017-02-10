package com.gowtham.controller;


import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gowtham.exception.ServiceException;
import com.gowtham.model.User;
import com.gowtham.service.UserService;
import com.gowtham.util.MailUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@GetMapping
	public String saveUser(@RequestParam("name") String name, @RequestParam("userName") String userName,
			@RequestParam("password") String password, @RequestParam("emailId") String emailId,
			@RequestParam("phoneNumber") String phoneNumber,ModelMap modelMap) {
		User user = new User();
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmailId(emailId);
		user.setPhoneNumber(phoneNumber);
		final UserService userService = new UserService();
		try {
			userService.register(user);
			MailUtil.sendSimpleMail(user);
			return "/"; 
		} catch (ServiceException e) {
			modelMap.addAttribute("REGISTER_ERROR", e.getMessage());
			return "register.jsp";
		} catch (EmailException e) {
			modelMap.addAttribute("REGISTER_ERROR", e.getMessage());
			return "register.jsp";
		}
	}
}	
