package org.yogocodes.bikewars.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.UserDao;
import org.yogocodes.bikewars.model.UserModel;

@Repository("userDao")
public class UserJdbcDaoImpl implements UserDao {

	private final Logger log = LoggerFactory.getLogger(UserJdbcDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserModel getUser(final Long sessionUserId) {
		final ResultSetExtractor<UserModel> extractor = new ResultSetExtractor<UserModel>() {
			@Override
			public UserModel extractData(final ResultSet rs) throws SQLException, DataAccessException {
				final UserModel userModel = new UserModel();
				final Long userId = rs.getLong("user_id");
				final Date created = rs.getDate("created");
				final String email = rs.getString("email");
				final Date modified = rs.getDate("modified");
				final String password = rs.getString("password");
				userModel.setUserId(userId);
				userModel.setCreated(created);
				userModel.setEmail(email);
				userModel.setModified(modified);
				userModel.setPassword(password);

				log.trace("loaded usermodel: {}", userModel);
				return userModel;
			}
		};
		final Object params[] = { sessionUserId };
		final UserModel userModel = jdbcTemplate.query("select * from users where user_id = ?", params, extractor);
		return userModel;
	}
}
