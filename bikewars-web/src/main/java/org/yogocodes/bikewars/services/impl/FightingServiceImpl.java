package org.yogocodes.bikewars.services.impl;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.model.FightResultModel;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.FightingService;
import org.yogocodes.bikewars.services.UserInfoService;

@Service("fightingService")
public class FightingServiceImpl implements FightingService {

	private final Logger logger = LoggerFactory
			.getLogger(FightingServiceImpl.class);

	private final Random random = new Random(System.currentTimeMillis());

	@Autowired
	private UserInfoService userInfoService; 
	
	@Override
	public FightResultModel fight(Long attackerId, Long defenderId) {

		
		UserInfoModel attacker = userInfoService.getUserInfo(attackerId);
		UserInfoModel defender = userInfoService.getUserInfo(defenderId);
		
		boolean isAttackSuccess = random.nextBoolean();
		Long stoledCash;
		if( isAttackSuccess ) {
			Integer cash = defender.getCash();
			stoledCash = calculateStoledCash(cash);
			defender.setCash((int) (defender.getCash() - stoledCash));
			attacker.setCash((int) (attacker.getCash() + stoledCash));
		}
		else {
			Integer cash = attacker.getCash();
			stoledCash = calculateStoledCash(cash);
			defender.setCash((int) (defender.getCash() + stoledCash));
			attacker.setCash((int) (attacker.getCash() - stoledCash));
		}
		userInfoService.saveUserInfo(attacker);
		userInfoService.saveUserInfo(defender);
		
		FightResultModel fightResult = new FightResultModel();
		fightResult.setAttackerId(attackerId);
		fightResult.setAttackerWon(isAttackSuccess);
		Date now = new Date();
		fightResult.setCreated(now );
		fightResult.setDefenderId(defenderId);
		fightResult.setMoney(stoledCash);
		
		
		
		return fightResult;
	}

	private long calculateStoledCash(Integer cash) {
		double percentage = random.nextDouble() * 0.4d;
		return (long) (cash * percentage);
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
