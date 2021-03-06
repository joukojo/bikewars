package org.yogocodes.bikewars.services;

import java.util.List;

import org.yogocodes.bikewars.model.StockModel;

public interface StockService {

	List<StockModel> getStocks();

	StockModel getStockById(Long stockId);

	void save(StockModel stock);

}
