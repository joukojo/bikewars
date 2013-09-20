package org.yogocodes.bikewars.scheduler;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.model.StockModel;
import org.yogocodes.bikewars.services.StockService;


@Service("stockPriceUpdateTaskService")
public class StockPriceUpdateTask {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private StockService stockService;
	@Scheduled(fixedRate = 15000, initialDelay = 6000)
	public void updateStockPrices() {
		logger.info("updating stock prices");
		
		List<StockModel> allStocks = getStockService().getStocks();
		
		
		for (StockModel stock : allStocks) {
			long delta = System.currentTimeMillis();  
			
			Long newPrice = (long) Math.round(stock.getMinPrice() + (double) (Math.sin(delta) * stock.getDeltaPrice())); 
			
			if( newPrice < stock.getMinPrice() ) {
				newPrice = stock.getMinPrice();
			}
			
			stock.setCurrentPrice(newPrice);
			stockService.save(stock);
		}
		
		logger.info("updated stock prices");
	}
	public StockService getStockService() {
		return stockService;
	}
	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}
}
