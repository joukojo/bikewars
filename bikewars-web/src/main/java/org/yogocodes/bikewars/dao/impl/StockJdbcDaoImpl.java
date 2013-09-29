package org.yogocodes.bikewars.dao.impl;

import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.StockDao;
import org.yogocodes.bikewars.model.StockModel;

import java.util.Date;
import java.util.List;

@Repository("stockDao")
public class StockJdbcDaoImpl implements StockDao {

    private final Logger log = LoggerFactory.getLogger(StockJdbcDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<StockModel> getStocks() {
        log.trace("getting all stocks");
        StopWatch stopWatch = new Log4JStopWatch();
        final String sql = "select * from stocks";
        final List<StockModel> stocks = jdbcTemplate.query(sql, new StockRowMapper());
        stopWatch.stop("stockDaoImpl", "find all stocks");
        log.trace("got all stocks");
        return stocks;
    }

    @Override
    public StockModel getStockById(final Long stockId) {
        log.trace("getting stock by id #{}", stockId);
        StockModel stock = null;
        StopWatch stopWatch = new Log4JStopWatch();
        final Object params[] = {stockId};
        final List<StockModel> stocks = jdbcTemplate.query("select * from stocks where id = ?", params, new StockRowMapper());
        stopWatch.lap("stockDaoImpl", "got stock by id from jdbc");
        log.trace("queried stock by id  #{}", stockId);
        if (stocks != null && !stocks.isEmpty()) {
            stock = stocks.get(0);
        }
        stopWatch.stop("stockDaoImpl", "get stock by id");
        return stock;
    }

    @Override
    public void save(StockModel stock) {
        log.trace("saving stock {}", stock);
        if (stock.getStockId() == null) {
            log.debug("inserting new stock");
            insert(stock);
            log.debug("inserted new stock");
        } else {
            log.debug("updating new stock");
            update(stock);
            log.debug("updated stock");
        }
    }

    private void insert(StockModel stock) {


    }

    private void update(StockModel stock) {
        final Date now = new Date();
        StopWatch stopWatch = new Log4JStopWatch();
        String sql = "update stocks set current_price = ?, modified =? where id = ?";
        Object args[] = {stock.getCurrentPrice(), now, stock.getStockId()};

        int rows = jdbcTemplate.update(sql, args);
        log.debug("updated single row: {}", rows);
        stopWatch.stop("stockDaoImpl", "updated stock");

    }
}
