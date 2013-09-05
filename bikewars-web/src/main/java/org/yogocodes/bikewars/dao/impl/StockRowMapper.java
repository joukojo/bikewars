package org.yogocodes.bikewars.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.yogocodes.bikewars.model.StockModel;

public class StockRowMapper implements RowMapper<StockModel> {

	@Override
	public StockModel mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		final StockModel stockModel = new StockModel();
		final Date created = rs.getDate("created");
		final Long currentPrice = rs.getLong("current_price");
		final String description = rs.getString("description");
		final Date modified = rs.getDate("modified");
		final String name = rs.getString("name");
		final Long stockId = rs.getLong("id");

		stockModel.setCreated(created);
		stockModel.setCurrentPrice(currentPrice);
		stockModel.setDescription(description);
		stockModel.setModified(modified);
		stockModel.setName(name);
		stockModel.setStockId(stockId);

		return stockModel;
	}

}
