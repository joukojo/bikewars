package org.yogocodes.bikewars.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.UserStockDao;
import org.yogocodes.bikewars.model.UserStockModel;

@Repository("userStockDao")
public class UserStockJdbcDaoImpl implements UserStockDao {

	private final Logger logger = LoggerFactory.getLogger(UserStockJdbcDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserStockModel> getUserStocks(final Long userId) {

		final String sql = "select * from user_stocks where user_id = ?";
		logger.trace("getting user stocks: {}", userId);
		final List<UserStockModel> userStocks = jdbcTemplate.query(sql, new UserStockRowMapper(), userId);
		logger.trace("got user stocks for user {}", userId);
		return userStocks;
	}

}
