package org.yogocodes.bikewars.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.dao.UserInfoDao;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	private final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserInfoModel getUserInfo(final Long userId) {
		log.trace("getting userinfo for {}", userId);

		final UserInfoModel userInfo = userInfoDao.getUserInfo(userId);

		return userInfo;
	}
}
