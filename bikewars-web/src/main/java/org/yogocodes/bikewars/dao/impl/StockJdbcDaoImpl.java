package org.yogocodes.bikewars.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.StockDao;
import org.yogocodes.bikewars.model.StockModel;

@Repository("stockDao")
public class StockJdbcDaoImpl implements StockDao {

	private final Logger log = LoggerFactory.getLogger(StockJdbcDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<StockModel> getStocks() {
		log.trace("getting all stocks");
		final String sql = "select * from stocks";
		final List<StockModel> stocks = jdbcTemplate.query(sql, new StockRowMapper());
		log.trace("got all stocks");
		return stocks;
	}

	@Override
	public StockModel getStockById(final Long stockId) {
		log.trace("getting stock by id #{}", stockId);
		StockModel stock = null;

		final Object params[] = { stockId };
		final List<StockModel> stocks = jdbcTemplate.query("select * from stocks where id = ?", params, new StockRowMapper());
		log.debug("queried stock by id  #{}", stockId);
		if (stocks != null && !stocks.isEmpty()) {
			stock = stocks.get(0);
		}

		return stock;
	}

	@Override
	public void save(StockModel stock) {
		if( stock.getStockId() == null ) {
			insert(stock);
		}
		else {
			update(stock);
		}
	}

	private void insert(StockModel stock) {
		
		
	}

	private void update(StockModel stock) {
		Date now = new Date();
		String sql = "update stocks set current_price = ?, modified =? where id = ?";
		Object args[] = {stock.getCurrentPrice(), now, stock.getStockId()};
		jdbcTemplate.update(sql, args);
		
	}
}
