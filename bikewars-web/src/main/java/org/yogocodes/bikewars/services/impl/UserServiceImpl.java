package org.yogocodes.bikewars.services.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.dao.UserDao;
import org.yogocodes.bikewars.model.UserModel;
import org.yogocodes.bikewars.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public UserModel getUser(final Long sessionUserId) {
		log.trace("getting user #{}", sessionUserId);

		final UserModel userModel = userDao.getUser(sessionUserId);
		return userModel;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserModel save(final UserModel user) {
		log.trace("storing user:{}", user);
		final Date now = new Date();
		if (user.getUserId() == null) {
			user.setCreated(now);
		}
		user.setModified(now);

		final UserModel storedUser = getUserDao().save(user);

		return storedUser;
	}

	@Override
	public UserModel getUser(final String userName, final String password) {

		log.trace("getting user by credetials: {} -> {}", userName, password);
		return getUserDao().getUser(userName, password);
	}

}
