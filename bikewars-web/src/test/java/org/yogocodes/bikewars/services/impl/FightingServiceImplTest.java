package org.yogocodes.bikewars.services.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.yogocodes.bikewars.dao.FightDao;
import org.yogocodes.bikewars.model.FightResultModel;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.UserInfoService;
import org.yogocodes.bikewars.util.FightResultModelUtil;
import org.yogocodes.bikewars.util.UserInfoModelUtil;


@RunWith(MockitoJUnitRunner.class)
public class FightingServiceImplTest {
	@Mock
	private FightDao fightDao;

	@Mock
	private UserInfoService userInfoService;
	@InjectMocks
	private FightingServiceImpl fightingServiceImpl;

	@Test
	public void testFightLongLong() throws Exception {

		final FightResultModel fightResult = new FightResultModel();
		Long defenderId = System.currentTimeMillis();
		Long attackerId = System.currentTimeMillis();
		final UserInfoModel attackerUserInfo = UserInfoModelUtil.createUserInfo(attackerId);
		final UserInfoModel defenderUserInfo = UserInfoModelUtil.createUserInfo(defenderId);
		
		fightingServiceImpl = new FightingServiceImpl() {
			@Override
			protected FightResultModel fight(UserInfoModel actualAttacker, UserInfoModel actualDefender) {
				assertNotNull("defender is null", actualDefender);
				assertNotNull("attacker is null", actualAttacker);
				
				return fightResult;
			}
		};
		fightingServiceImpl.setUserInfoService(userInfoService);
		
		Mockito.when(userInfoService.getUserInfo(attackerId)).thenReturn(attackerUserInfo);
		
		Mockito.when(userInfoService.getUserInfo(attackerId)).thenReturn(defenderUserInfo);

		FightResultModel actualFightResult = fightingServiceImpl.fight(attackerId, defenderId);
		assertNotNull("fight result is null", actualFightResult);

	}


	@Test
	public void testFightUserInfoModelUserInfoModel() throws Exception {
	
		final UserInfoModel attacker = UserInfoModelUtil.createUserInfo(System.currentTimeMillis());
		final UserInfoModel defender = UserInfoModelUtil.createUserInfo(System.currentTimeMillis());
		
		final FightResultModel fightResult = FightResultModelUtil.createFightResult();
		fightResult.setAttackerWon(true);

		
		fightingServiceImpl = new FightingServiceImpl() {
			@Override
			protected boolean calculateFightResult() {
				return true;
			}
			
			@Override
			protected Long executeFight(UserInfoModel winner, UserInfoModel loser) {
				assertEquals("attacker should be loserr", attacker, winner);
				assertEquals("defender should be loser", defender, loser);
				return 100L;
			}
			
			@Override
			protected FightResultModel createFightResult(UserInfoModel attacker, UserInfoModel defender, boolean isAttackSuccess, Long stolenCash) {
				return fightResult;
				
			}
			
		};
		fightingServiceImpl.setUserInfoService(userInfoService);
		fightingServiceImpl.setFightDao(fightDao);
		
		
		
		FightResultModel actualFightResult = fightingServiceImpl.fight(attacker, defender);
		
		assertTrue("fight result is wrong",  actualFightResult.isAttackerWon());  
	}



	@Test
	public void testGetRecentFights() throws Exception {
		Integer pageSize = 100;

		Long userId = System.currentTimeMillis();
		Integer pageNum = 0;
		
		List<FightResultModel> actualFights = FightResultModelUtil.createFightResults(pageSize);
		
		Mockito.when(this.fightDao.getLatestFights(userId, pageNum, pageSize)).thenReturn(actualFights );
		List<FightResultModel> recentFights = fightingServiceImpl.getRecentFights(userId, pageNum, pageSize);
		
		assertEquals(actualFights, recentFights);
	}



}
