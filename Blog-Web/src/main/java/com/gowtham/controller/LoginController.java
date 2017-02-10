package com.gowtham.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gowtham.exception.ServiceException;
import com.gowtham.model.User;
import com.gowtham.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String login(@RequestParam("userName")String userName,@RequestParam("password")String password,ModelMap modelMap,HttpSession session){
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		UserService userService = new UserService();
		try {
			userService.login(user);
		} catch (ServiceException e) {
			modelMap.addAttribute("LOGIN_ERROR", e.getMessage());
			return "/";
		}
		user=userService.getUser(userName);
		session.setAttribute("USER", user);
		return "/showList";
	}
	
}
