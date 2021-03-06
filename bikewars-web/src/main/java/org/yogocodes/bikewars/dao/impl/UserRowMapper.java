package org.yogocodes.bikewars.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.yogocodes.bikewars.model.UserModel;

public class UserRowMapper implements RowMapper<UserModel> {
	private final Logger log = LoggerFactory.getLogger(UserRowMapper.class);

	@Override
	public UserModel mapRow(final ResultSet rs, final int rowNum) throws SQLException {

		final Long userId = rs.getLong("id");
		final Date created = rs.getDate("created");
		final String email = rs.getString("email");
		final Date modified = rs.getDate("modified");
		final String password = rs.getString("password");

		final UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		userModel.setCreated(created);
		userModel.setEmail(email);
		userModel.setModified(modified);
		userModel.setPassword(password);

		log.trace("loaded usermodel: {}", userModel);
		return userModel;

	}
}
