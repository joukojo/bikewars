package org.yogocodes.bikewars.web.personal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yogocodes.bikewars.model.StockModel;
import org.yogocodes.bikewars.model.UserStockModel;
import org.yogocodes.bikewars.model.UserStockView;
import org.yogocodes.bikewars.services.StockService;
import org.yogocodes.bikewars.services.UserStockService;
import org.yogocodes.bikewars.util.UserSessionUtil;

@Controller
public class StockController {

	private final Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@Autowired
	private UserStockService userStockService;

	@RequestMapping(value = "/personal/stocks", method = RequestMethod.GET)
	public String listStocks(final HttpSession httpSession, final Model model) {
		logger.trace("list stocks");

		final List<StockModel> stocks = stockService.getStocks();
		final Long userId = UserSessionUtil.getUserId(httpSession);
		final Map<Long, UserStockModel> userStocks = userStockService.getGroupedUserStocks(userId);

		final ArrayList<Object> userStockViews = new ArrayList<>();
		for (final StockModel stockModel : stocks) {
			final Long stockId = stockModel.getStockId();
			final UserStockModel userStockModel = userStocks.get(stockId);
			final UserStockView userStockView = new UserStockView(userStockModel, stockModel);
			userStockViews.add(userStockView);
		}

		model.addAttribute("stocks", userStockViews);

		return "personal/stocks";
	}
}
