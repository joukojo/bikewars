package org.yogocodes.bikewars.web.personal;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yogocodes.bikewars.model.StockModel;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.model.UserStockModel;
import org.yogocodes.bikewars.model.UserStockView;
import org.yogocodes.bikewars.services.StockService;
import org.yogocodes.bikewars.services.UserInfoService;
import org.yogocodes.bikewars.services.UserStockService;
import org.yogocodes.bikewars.util.UserSessionUtil;

@Controller
public class StockController {

	private final Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@Autowired
	private UserStockService userStockService;

	@Autowired
	private UserInfoService userInfoService;

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

	@RequestMapping(value = "/personal/stockevent")
	@ResponseBody
	public UserStockModel handleStockEvent(@RequestParam("stockid") final Long stockId, @RequestParam("event") final String event, final HttpSession httpSession) {
		logger.trace("handling stock {} - {}", stockId, event);
		final Long userId = UserSessionUtil.getUserId(httpSession);

		if ("buy".equals(event)) {
			final long amount = 1L;
			buyStock(userId, stockId, amount);

		} else if ("buy5".equals(event)) {
			final long amount = 5L;
			buyStock(userId, stockId, amount);

		} else if ("sell".equals(event)) {
			sellStock(userId, stockId, 1L);

		} else if ("sell5".equals(event)) {
			sellStock(userId, stockId, 5L);
		}

		return new UserStockModel();

	}

	private void buyStock(final Long userId, final Long stockId, final long amount) {
		final StockModel stockById = stockService.getStockById(stockId);

		final UserInfoModel userInfo = userInfoService.getUserInfo(userId);

		final Integer cash = userInfo.getCash();
		UserStockModel stockByUser = userStockService.getStockByUser(userId, stockId);
		if (cash >= stockById.getCurrentPrice()) {
			if (stockByUser != null) {

				final Long stockPrice = stockByUser.getCount() * stockByUser.getPurchasePrice() + amount * stockById.getCurrentPrice();

				stockByUser.setCount(stockByUser.getCount() + amount);
				stockByUser.setPurchasePrice(stockPrice / stockByUser.getCount());
			} else {
				stockByUser = new UserStockModel();
				stockByUser.setCount(amount);
				stockByUser.setPurchasePrice(stockById.getCurrentPrice());
				stockByUser.setPurchaseDate(new Date());
				stockByUser.setUserId(userId);
				stockByUser.setStockId(stockId);
			}
			final Integer newCash = (int) (cash - amount * stockById.getCurrentPrice());
			userInfo.setCash(newCash);
			userInfoService.saveUserInfo(userInfo);
			userStockService.save(stockByUser);
		}
	}

	private void sellStock(final Long userId, final Long stockId, final long amount) {
		final StockModel stockById = stockService.getStockById(stockId);

		final UserInfoModel userInfo = userInfoService.getUserInfo(userId);

		final Integer cash = userInfo.getCash();
		final UserStockModel stockByUser = userStockService.getStockByUser(userId, stockId);

		if (stockByUser != null) {

			final long newCount = stockByUser.getCount() - amount;

			if (newCount >= 0) {
				stockByUser.setCount(newCount);

				final long stockPrice = stockByUser.getCount() * stockByUser.getPurchasePrice();
				if (newCount == 0) {
					stockByUser.setPurchasePrice(0L);
				} else {
					stockByUser.setPurchasePrice(stockPrice / newCount);
				}
				final Integer newCash = (int) (cash + amount * stockById.getCurrentPrice());
				userInfo.setCash(newCash);
				userInfoService.saveUserInfo(userInfo);
				userStockService.save(stockByUser);
			}
		}

	}

}
