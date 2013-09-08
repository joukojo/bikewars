package org.yogocodes.bikewars.services;

import java.util.List;
import java.util.Map;

import org.yogocodes.bikewars.model.UserStockModel;

public interface UserStockService {
	List<UserStockModel> getUserStocks(final Long userId);

	Map<Long, UserStockModel> getGroupedUserStocks(Long userId);
}
