package org.yogocodes.bikewars.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yogocodes.bikewars.model.UserModel;
import org.yogocodes.bikewars.services.UserService;
import org.yogocodes.bikewars.util.UserSessionUtil;

@Controller
public class UserRegistrationController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	@ModelAttribute
	public UserModel createNewModel(@RequestParam(required = false, value = "id") final Long userId, final HttpSession session) {
		log.trace("loading model for the userId: {}", userId);
		final Long sessionUserId = UserSessionUtil.getUserId(session);

		if (userId != null) {
			return handleUserModification(userId, sessionUserId);
		}

		return new UserModel();
	}

	protected UserModel handleUserModification(final Long userId, final Long sessionUserId) {
		if (userId == sessionUserId) {
			// FIXME add the user loading from service
		} else {
			log.warn("tried to modify another user's session");

		}
		return new UserModel();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String view(@RequestParam(required = false, value = "id") final Long userId, final HttpSession session) {
		log.trace("view form: {}", userId);

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute final UserModel user, final HttpSession session) {
		log.trace("registering user: {}", user);
		user.setUserId(System.currentTimeMillis());
		final Date now = new Date();
		user.setCreated(now);
		user.setModified(now);
		UserSessionUtil.setUser(session, user);
		return "redirect:/ownpage.htm";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}
}
