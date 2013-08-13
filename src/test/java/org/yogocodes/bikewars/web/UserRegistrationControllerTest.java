package org.yogocodes.bikewars.web;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.yogocodes.bikewars.model.UserModel;
import org.yogocodes.bikewars.services.UserService;
import org.yogocodes.bikewars.util.UserModelUtil;
import org.yogocodes.bikewars.util.UserSessionUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationControllerTest {
	@Mock
	private UserService userService;
	@InjectMocks
	private UserRegistrationController userRegistrationController;

	@Test
	public void testCreateNewModelNotLoggedUser() {
		Assert.assertNotNull("userservice is null", userRegistrationController.getUserService());
		final UserModel actualModel = userRegistrationController.createNewModel(null, new MockHttpSession());

		Assert.assertNotNull("model creation failed", actualModel);
		Assert.assertNull("model's id is not null", actualModel.getUserId());

	}

	@Test
	public void testCreateNewModelLoggedUser() {
		Assert.assertNotNull("userservice is null", userRegistrationController.getUserService());
		final HttpSession session = new MockHttpSession();
		final UserModel userModel = UserModelUtil.createUser();
		UserSessionUtil.setUser(session, userModel);
		final UserModel actualModel = userRegistrationController.createNewModel(null, session);

		Assert.assertNotNull("model creation failed", actualModel);
		Assert.assertNull("model's id is not null", actualModel.getUserId());

	}

	@Test
	public void testView() {
		Assert.assertNotNull("userservice is null", userRegistrationController.getUserService());

	}

	@Test
	public void testRegister() {
		Assert.assertNotNull("userservice is null", userRegistrationController.getUserService());

	}

}
