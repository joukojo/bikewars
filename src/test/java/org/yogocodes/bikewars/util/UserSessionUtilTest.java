package org.yogocodes.bikewars.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;

public class UserSessionUtilTest {

	@Test
	public void testGetUserIdNotLogged() {
		final MockHttpSession httpSession = new MockHttpSession();

		final Long userId = UserSessionUtil.getUserId(httpSession);

		Assert.assertNull("user id should be null", userId);
	}

	@Test
	public void testGetUserIdLogged() {
		final MockHttpSession httpSession = new MockHttpSession();
		final Long userId = System.currentTimeMillis();
		httpSession.setAttribute("USER_ID", userId);

		final Long actualUserId = UserSessionUtil.getUserId(httpSession);

		Assert.assertNotNull("user id should not be null", actualUserId);
		Assert.assertEquals("user id is invalid", userId, actualUserId);
	}
}
