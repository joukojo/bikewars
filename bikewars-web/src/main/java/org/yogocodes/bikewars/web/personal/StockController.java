package org.yogocodes.bikewars.web.personal;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yogocodes.bikewars.model.StockModel;
import org.yogocodes.bikewars.services.StockService;

@Controller
public class StockController {

	private final Logger logger = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/personal/stocks", method = RequestMethod.GET)
	public String listStocks(final HttpSession httpSession, final Model model) {
		logger.trace("list stocks");

		final List<StockModel> stocks = stockService.getStocks();
		model.addAttribute("stocks", stocks);

		return "personal/stocks";
	}

}
