package org.yogocodes.bikewars.util;

import java.util.ArrayList;
import java.util.List;

import org.yogocodes.bikewars.model.UserInfoModel;

public class UserInfoModelUtil {
	
	public static  UserInfoModel createUserInfo(Long userId) {
		final UserInfoModel userInfo = new UserInfoModel(); 
		userInfo.setUserId(userId);
		userInfo.setCash(1000);
		return userInfo;
	}
	
	public static List<UserInfoModel> createUserInfos(int count) {
		List<UserInfoModel> users = new ArrayList<>(count);
		for( int i = 0 ; i < count ; i++ ){
			UserInfoModel user = createUserInfo(System.currentTimeMillis());
			users.add(user);
		}
		
		
		return users;
	}


}
