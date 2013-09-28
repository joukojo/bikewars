package org.yogocodes.bikewars.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.dao.FightDao;
import org.yogocodes.bikewars.model.FightResultModel;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.FightingService;
import org.yogocodes.bikewars.services.UserInfoService;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service("fightingService")
public class FightingServiceImpl implements FightingService {

    private final Logger logger = LoggerFactory.getLogger(FightingServiceImpl.class);
    private final Random random = new Random(System.currentTimeMillis());
    @Autowired
    protected UserInfoService userInfoService;
    @Autowired
	private FightDao fightDao;

    @Override
    public FightResultModel fight(Long attackerId, Long defenderId) {


        UserInfoModel attacker = userInfoService.getUserInfo(attackerId);
        UserInfoModel defender = userInfoService.getUserInfo(defenderId);

        if (logger.isTraceEnabled()) {
            logger.trace("attacker: {}", attacker);
            logger.trace("defender: {}", defender);
        }

        FightResultModel fightResult = fight(attacker,defender);


        return fightResult;
    }

	protected  FightResultModel fight(UserInfoModel attacker, UserInfoModel defender) {
		boolean isAttackSuccess = calculateFightResult();
        Long stolenCash;
        if (isAttackSuccess) {
            stolenCash = executeFight(attacker, defender);
        } else {
        	stolenCash = executeFight(defender, attacker);
        }
        
		FightResultModel fightResult = createFightResult(attacker, defender, isAttackSuccess, stolenCash);
        
        userInfoService.saveUserInfo(attacker);
        userInfoService.saveUserInfo(defender);
        getFightDao().save(fightResult);

        
		return fightResult;
	}

	protected  Long executeFight(UserInfoModel winner, UserInfoModel loser) {
		Integer cash = loser.getCash();
		Long stolenCash = calculateStolenCash(cash);
		loser.setCash((int) (loser.getCash() - stolenCash));
		winner.setCash((int) (winner.getCash() + stolenCash));
		return stolenCash;
	}

	protected  FightResultModel createFightResult(UserInfoModel attacker, UserInfoModel defender, boolean isAttackSuccess, Long stolenCash) {
		Long attackerId = attacker.getUserId();
		Long defenderId = defender.getUserId();
        FightResultModel fightResult = new FightResultModel();
        fightResult.setAttackerId(attackerId);
        fightResult.setAttackerWon(isAttackSuccess);
        Date now = new Date();
        fightResult.setCreated(now);
        fightResult.setDefenderId(defenderId);
        fightResult.setMoney(stolenCash);
		return fightResult;
	}

	protected  boolean calculateFightResult() {
		return random.nextBoolean();
	}

    private long calculateStolenCash(Integer cash) {
        double percentage = random.nextDouble() * 0.4d;
        return (long) (cash * percentage);
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public List<FightResultModel> getRecentFights(Long userId, Integer pageNum, Integer pageSize) {
        logger.trace("getting recent fights for {} - {} / {}", userId, pageNum, pageSize);
        List<FightResultModel> recentFights = getFightDao().getLatestFights(userId, pageNum, pageSize);
        return recentFights;
    }

	public FightDao getFightDao() {
		return fightDao;
	}

	public void setFightDao(FightDao fightDao) {
		this.fightDao = fightDao;
	}
}
