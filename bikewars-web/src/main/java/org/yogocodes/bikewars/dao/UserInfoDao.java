package org.yogocodes.bikewars.dao;

import org.yogocodes.bikewars.model.UserInfoModel;

public interface UserInfoDao {

	UserInfoModel getUserInfo(Long userId);

}
