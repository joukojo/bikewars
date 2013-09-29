package org.yogocodes.bikewars.web.personal;

import javax.servlet.http.HttpSession;

import org.perf4j.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yogocodes.bikewars.model.FightResultModel;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.FightingService;
import org.yogocodes.bikewars.services.UserInfoService;
import org.yogocodes.bikewars.util.UserSessionUtil;

import java.util.List;

@Controller
public class OwnPageController {

	private final Logger log = LoggerFactory.getLogger(OwnPageController.class);

    @Autowired
    protected FightingService fightingService;
    
    @Autowired
	private UserInfoService userInfoService;
    
	@RequestMapping(value = "/personal/ownpage", method = RequestMethod.GET)
	public String view(final HttpSession session, final Model model) {
		StopWatch stopWatch = new StopWatch("ownpagecontroller");
		
		final Long userId = UserSessionUtil.getUserId(session);
		
        List<FightResultModel> recentFights = fightingService.getRecentFights(userId, 0, 5);
        stopWatch.lap("ownpagecontroller", "got recent fights");

        List<UserInfoModel> highestUsers = userInfoService.getHighestUsers();
        
        model.addAttribute("fights", recentFights);
        model.addAttribute("users", highestUsers);
        
		log.trace("entering ownpage for user:{}", userId);
		stopWatch.stop();
		return "personal/ownpage";
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
}
