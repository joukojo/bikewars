package org.yogocodes.bikewars.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginPageController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public String view() {
		
		return "login"; 
	}
	
	
	@RequestMapping(value="/user-login", method=RequestMethod.POST)
	public String doLogin(@RequestParam(value="username") String userName, @RequestParam(value="password") String password, HttpServletRequest request) {
		log.trace("doLogin for user {}", userName);
		HttpSession session = request.getSession();
		
		session.setAttribute("isLogged", Boolean.TRUE);
		session.setAttribute("userName", userName);
		
		return "redirect:index.htm"; 
	}
}
