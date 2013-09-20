package org.yogocodes.bikewars.util;

import javax.servlet.http.HttpSession;

import org.yogocodes.bikewars.model.UserModel;

public class UserSessionUtil {

	protected static final String USER_ID_SESSION_ATTR = "USER_ID";
	protected static final String USER_SESSION_ATTR = "USER";

	private UserSessionUtil() {
	}

	public static final Long getUserId(final HttpSession httpSession) {
		final Object attributeValue = httpSession.getAttribute(USER_ID_SESSION_ATTR);
		if (attributeValue == null) {
			return null;
		}

		return Long.valueOf(String.valueOf(attributeValue));
	}

	public static void setUser(final HttpSession httpSession, final UserModel userModel) {
		if (userModel != null) {
			httpSession.setAttribute(USER_ID_SESSION_ATTR, userModel.getUserId());
			httpSession.setAttribute(USER_SESSION_ATTR, userModel);
		}

	}

}
