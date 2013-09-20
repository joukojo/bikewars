package org.yogocodes.bikewars.web.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yogocodes.bikewars.model.UserModel;
import org.yogocodes.bikewars.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/personal/json/user", produces = "application/json")
	public @ResponseBody
	UserModel getUser(@RequestParam(value = "userid", required = true) final Long userId) {

		final UserModel user = getUserService().getUser(userId);
		user.setPassword(null);
		return user;

	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

}
