package org.yogocodes.bikewars.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;
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

		StopWatch stopWatch = new LoggingStopWatch();
		final UserInfoModel userInfo = userInfoDao.getUserInfo(userId);
		stopWatch.stop("UserINfoService", "Get userinfo");
		return userInfo;
	}

	@Override
	public void saveUserInfo(final UserInfoModel userInfo) {
		log.trace("saving user info: {}", userInfo);
		StopWatch stopWatch = new LoggingStopWatch();
		userInfoDao.save(userInfo);
		stopWatch.stop("UserINfoService", "saving userinfo");
	}

	@Override
	public List<UserInfoModel> getAttackbleUsers(Long attackerUserId, int page, int pageSize) {
		log.trace("getAttackbleUsers( [}, {}, {})", attackerUserId, page, pageSize);
		StopWatch stopWatch = new LoggingStopWatch("UserInfoService"); 
		List<UserInfoModel> attackbleUsers = userInfoDao.getAttackbleUsers(page, pageSize);
		
		List<UserInfoModel> filteredUsers = new ArrayList<>(attackbleUsers.size());
		for (UserInfoModel userInfoModel : attackbleUsers) {
			if (userInfoModel.getUserId().equals(attackerUserId)) {
				continue;
			}
			filteredUsers.add(userInfoModel);
		}
		stopWatch.stop("UserInfoService", "get attackble users");
		return filteredUsers;
	}
	
	@Override
	public List<UserInfoModel> getHighestUsers() {
		
		return userInfoDao.getHighestUsers();
	}
}
