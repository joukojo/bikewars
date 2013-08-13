package org.yogocodes.bikewars.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yogocodes.bikewars.model.UserModel;
import org.yogocodes.bikewars.services.UserService;
import org.yogocodes.bikewars.util.UserSessionUtil;

@Controller
public class UserLoginPageController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user-login", method = RequestMethod.GET)
	public String view() {

		return "login";
	}

	@RequestMapping(value = "/user-login", method = RequestMethod.POST)
	public String doLogin(@RequestParam(value = "username") final String userName, @RequestParam(value = "password") final String password, final HttpServletRequest request) {
		log.trace("doLogin for user {}", userName);

		final UserModel userModel = getUserService().getUser(userName, password);

		log.trace("userModel for user {} -> {}", userName, userModel);
		if (userModel != null) {
			final HttpSession session = request.getSession();
			log.trace("setting the user session");
			UserSessionUtil.setUser(session, userModel);
		}
		return "redirect:index.htm";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}
}
