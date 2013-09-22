package org.yogocodes.bikewars.web.personal;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yogocodes.bikewars.model.FightResultModel;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.FightingService;
import org.yogocodes.bikewars.services.UserInfoService;
import org.yogocodes.bikewars.util.UserSessionUtil;

@Controller
public class FightController {

	private final Logger logger = LoggerFactory.getLogger(FightController.class);
	@Autowired
	private UserInfoService userInfoService; 
	
	@Autowired
	private FightingService fightingService;
	
	@RequestMapping(value="/personal/fights", method=RequestMethod.GET)
	public String view(HttpSession session, Model model) {
		logger.trace("viewing fights");
		Long userId = UserSessionUtil.getUserId(session);
		
		int page = 0, pageSize = 5;
		List<UserInfoModel> users = userInfoService.getAttackbleUsers(userId,page, pageSize);
		
		Collections.shuffle(users);
		model.addAttribute("users", users);
		return "personal/fights";
	}
	
	@RequestMapping(value="/json/personal/fights/{targetUserId}")
	@ResponseBody
	public FightResultModel executeFight(@PathVariable Long targetUserId, HttpSession session) {
		Long userId = UserSessionUtil.getUserId(session);
		
		FightResultModel fightResult = fightingService.fight(userId, targetUserId);
		
		return fightResult;
	}
}
