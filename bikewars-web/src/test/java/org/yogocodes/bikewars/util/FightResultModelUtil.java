package org.yogocodes.bikewars.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.yogocodes.bikewars.model.FightResultModel;

public class FightResultModelUtil {
	
	public static  List<FightResultModel> createFightResults(int count) {
		List<FightResultModel> actualFights = new ArrayList<>();
		for( int i = 0 ; i< count ; i++ ) {
			FightResultModel result = createFightResult();
			actualFights.add(result);
		}
		return actualFights;
	}


	public static FightResultModel createFightResult() {
		FightResultModel result = new FightResultModel(); 
		result.setFight(System.currentTimeMillis());
		result.setAttackerId(System.currentTimeMillis());
		result.setDefenderId(System.currentTimeMillis());
		result.setCreated(new Date());
		result.setMoney((long) 1000);
		return result;
	}


}
