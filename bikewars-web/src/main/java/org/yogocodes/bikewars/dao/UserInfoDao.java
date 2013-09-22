package org.yogocodes.bikewars.dao;

import java.util.List;

import org.yogocodes.bikewars.model.UserInfoModel;

public interface UserInfoDao {

	UserInfoModel getUserInfo(Long userId);

	void save(UserInfoModel userInfo);

	List<UserInfoModel> getAttackbleUsers(int page, int pageSize);

}
