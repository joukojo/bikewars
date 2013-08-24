package org.yogocodes.bikewars.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLogoutController {

	@RequestMapping(value = "/logout")
	public String logout(final HttpSession httpSession) {
		httpSession.invalidate();

		return "redirect:/index.htm";
	}

}
