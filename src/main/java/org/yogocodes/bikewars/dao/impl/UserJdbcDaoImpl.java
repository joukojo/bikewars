package org.yogocodes.bikewars.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		final UserResultSetExtractor extractor = new UserResultSetExtractor();
		final Object params[] = { sessionUserId };
		final List<UserModel> users = jdbcTemplate.query("select * from users where user_id = ?", params, extractor);
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}

		return null;
	}

	@Override
	public UserModel getUser(final String userName, final String password) {

		final UserResultSetExtractor extractor = new UserResultSetExtractor();
		final Object params[] = { userName, password };
		final List<UserModel> users = jdbcTemplate.query("select * from users where email = ? and password = ?", params, extractor);

		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}

		return null;

	}
}
