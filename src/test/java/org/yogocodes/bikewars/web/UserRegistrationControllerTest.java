package org.yogocodes.bikewars.web;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.yogocodes.bikewars.model.UserModel;
import org.yogocodes.bikewars.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationControllerTest {
	@Mock
	private UserService userService;
	@InjectMocks
	private UserRegistrationController userRegistrationController;

	@Test
	public void testCreateNewModel() {
		Assert.assertNotNull("userservice is null", userRegistrationController.getUserService());
		final UserModel actualModel = userRegistrationController.createNewModel(null, new MockHttpSession());

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
