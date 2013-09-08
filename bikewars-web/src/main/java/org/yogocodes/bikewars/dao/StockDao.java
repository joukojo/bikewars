package org.yogocodes.bikewars.dao;

import java.util.List;

import org.yogocodes.bikewars.model.StockModel;

public interface StockDao {

	List<StockModel> getStocks();

	StockModel getStockById(Long stockId);

}
