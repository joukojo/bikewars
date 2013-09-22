package org.yogocodes.bikewars.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.dao.UserInfoDao;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	private final Logger log = LoggerFactory
			.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfoModel getUserInfo(final Long userId) {
		log.trace("getting userinfo for {}", userId);

		final UserInfoModel userInfo = userInfoDao.getUserInfo(userId);

		return userInfo;
	}

	@Override
	public void saveUserInfo(final UserInfoModel userInfo) {
		userInfoDao.save(userInfo);

	}

	@Override
	public List<UserInfoModel> getAttackbleUsers(Long attackerUserId, int page,
			int pageSize) {

		List<UserInfoModel> attackbleUsers = userInfoDao.getAttackbleUsers(
				page, pageSize);
		List<UserInfoModel> filteredUsers = new ArrayList<>(
				attackbleUsers.size());
		for (UserInfoModel userInfoModel : attackbleUsers) {
			if (userInfoModel.getUserId().equals(attackerUserId) ) {
				continue;
			}
			filteredUsers.add(userInfoModel);
		}

		return filteredUsers;
	}
}
