package org.yogocodes.bikewars.util;

import java.util.Date;

import org.yogocodes.bikewars.model.UserModel;

public class UserModelUtil {

	public static final UserModel createUser() {
		return createUser(System.currentTimeMillis());
	}

	public static final UserModel createUser(final Long userId) {
		final UserModel userModel = new UserModel();
		userModel.setEmail("junit" + userId + "@junittest.com");
		final Date now = new Date();
		userModel.setCreated(now);
		userModel.setModified(now);
		userModel.setPassword("dummypassword");
		userModel.setUserId(userId);
		return userModel;
	}

}
