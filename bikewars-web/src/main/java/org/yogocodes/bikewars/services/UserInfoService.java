package org.yogocodes.bikewars.services;

import java.util.List;

import org.yogocodes.bikewars.model.UserInfoModel;

public interface UserInfoService {

	UserInfoModel getUserInfo(Long userId);

	void saveUserInfo(UserInfoModel userInfo);



	List<UserInfoModel> getAttackbleUsers(Long attackerUserId, int page,
			int pageSize);

}
