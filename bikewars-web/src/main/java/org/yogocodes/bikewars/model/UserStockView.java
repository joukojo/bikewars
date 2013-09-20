package org.yogocodes.bikewars.model;

import java.util.Date;

public class UserStockView {

	private Long stockId;
	private String name;
	private String description;
	private Long currentPrice;
	private Date created;
	private Date modified;
	private Long id;
	private Long userId;
	private Long count;
	private Date purchaseDate;
	private Long purchasePrice;

	public UserStockView(final UserStockModel userStock, final StockModel stockModel) {
		if (userStock != null) {
			count = userStock.getCount();
			id = userStock.getId();
			purchaseDate = userStock.getPurchaseDate();
			purchasePrice = userStock.getPurchasePrice();
		} else {
			count = 0L;
			id = 0L;

		}

		if (stockModel != null) {
			setStockId(stockModel.getStockId());
			name = stockModel.getName();
			description = stockModel.getDescription();
			currentPrice = stockModel.getCurrentPrice();
			created = stockModel.getCreated();
			modified = stockModel.getModified();
		}
	}

	public Long getStockId() {
		return stockId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Long getCurrentPrice() {
		return currentPrice;
	}

	public Date getCreated() {
		return created;
	}

	public Date getModified() {
		return modified;
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId; 
	}
	public Long getCount() {
		return count;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public Long getPurchasePrice() {
		return purchasePrice;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

}
