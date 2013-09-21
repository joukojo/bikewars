package org.yogocodes.bikewars.web.personal;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.UserInfoService;

@Controller
public class FightController {

	private final Logger logger = LoggerFactory.getLogger(FightController.class);
	@Autowired
	private UserInfoService userInfoService; 
	
	@RequestMapping(value="/personal/fights", method=RequestMethod.GET)
	public String view(Model model) {
		logger.trace("viewing fights");
		int page = 0, pageSize = 100;
		List<UserInfoModel> users = userInfoService.getAttackbleUsers(page, pageSize);
		model.addAttribute("users", users);
		return "personal/fights";
	}
}
