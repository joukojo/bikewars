package org.yogocodes.bikewars.util;

import javax.servlet.http.HttpSession;

public class UserSessionUtil {

	private UserSessionUtil() {
	}

	public static final Long getUserId(final HttpSession httpSession) {
		final Object attributeValue = httpSession.getAttribute("USER_ID");
		if (attributeValue == null) {
			return null;
		}

		return Long.valueOf(String.valueOf(attributeValue));
	}

}
