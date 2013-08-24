package org.yogocodes.bikewars.dao;

import org.yogocodes.bikewars.model.UserModel;

public interface UserDao {

	UserModel getUser(Long sessionUserId);

	UserModel getUser(String userName, String password);

	UserModel save(UserModel user);

}
