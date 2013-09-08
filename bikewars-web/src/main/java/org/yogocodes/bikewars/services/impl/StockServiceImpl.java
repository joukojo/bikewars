package org.yogocodes.bikewars.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.dao.StockDao;
import org.yogocodes.bikewars.model.StockModel;
import org.yogocodes.bikewars.services.StockService;

@Service("stockService")
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;

	private final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

	@Override
	public List<StockModel> getStocks() {
		logger.trace("get stocks");
		final List<StockModel> stocks = stockDao.getStocks();

		return stocks;
	}

}
