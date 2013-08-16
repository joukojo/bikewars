package org.yogocodes.bikewars.web.personal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yogocodes.bikewars.util.UserSessionUtil;

@Controller
public class OwnPageController {

	private final Logger log = LoggerFactory.getLogger(OwnPageController.class);

	@RequestMapping(value = "/personal/ownpage", method = RequestMethod.GET)
	public String view(final HttpSession session, final Model model) {
		final Long userId = UserSessionUtil.getUserId(session);
		log.trace("entering ownpage for user:{}", userId);
		return "personal/ownpage";
	}
}
