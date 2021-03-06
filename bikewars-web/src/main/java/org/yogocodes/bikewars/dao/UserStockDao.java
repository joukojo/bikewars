package org.yogocodes.bikewars.dao;

import java.util.List;

import org.yogocodes.bikewars.model.UserStockModel;

public interface UserStockDao {

	List<UserStockModel> getUserStocks(Long userId);

	UserStockModel getUserStock(Long userId, Long stockId);

	void save(UserStockModel stockByUser);

}
