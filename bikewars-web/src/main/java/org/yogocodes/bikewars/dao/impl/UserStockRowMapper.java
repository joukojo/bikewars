package org.yogocodes.bikewars.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.yogocodes.bikewars.model.UserStockModel;

public class UserStockRowMapper implements RowMapper<UserStockModel> {

	@Override
	public UserStockModel mapRow(final ResultSet rs, final int rowNum) throws SQLException {

		final long id = rs.getLong("id");
		final Long userId = rs.getLong("user_id");
		final long stockId = rs.getLong("stock_id");
		final Long count = rs.getLong("count");
		final Date purchaseDate = rs.getDate("purchase_date");
		final long purchasePrice = rs.getLong("purchase_price");

		final UserStockModel userStock = new UserStockModel();
		userStock.setCount(count);
		userStock.setId(id);
		userStock.setPurchaseDate(purchaseDate);
		userStock.setPurchasePrice(purchasePrice);
		userStock.setUserId(userId);
		userStock.setStockId(stockId);
		return userStock;
	}
}
