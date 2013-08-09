package org.yogocodes.bikewars.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yogocodes.bikewars.model.UserModel;

@Controller
public class UserRegistrationController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@ModelAttribute
	public UserModel createNewModel(@RequestParam(required=false, value="id") final Long userId) {
		
		return new UserModel();
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String view(@RequestParam(required=false, value="id") final Long userId, final HttpSession session) {
		log.trace("view form: {}", userId);
		
		
		
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute UserModel user) {
		log.trace("registering user: {}", user);
		
		return "redirect:/ownpage.htm"; 
	}
}
