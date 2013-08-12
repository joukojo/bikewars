package org.yogocodes.bikewars.services;

import org.yogocodes.bikewars.model.UserModel;

public interface UserService {

	UserModel getUser(Long sessionUserId);

	UserModel save(UserModel user);

}
