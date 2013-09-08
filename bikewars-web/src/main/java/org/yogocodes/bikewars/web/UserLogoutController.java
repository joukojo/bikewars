package org.yogocodes.bikewars.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLogoutController {

	private final Logger logger = LoggerFactory.getLogger(UserLogoutController.class);

	@RequestMapping(value = "/logout")
	public String logout(final HttpSession httpSession) {
		logger.trace("invalidating session:{}", httpSession.getId());
		httpSession.invalidate();

		return "redirect:/index.htm";
	}

}
