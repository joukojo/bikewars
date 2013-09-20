package org.yogocodes.bikewars.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserStockModel {

	/**
	 * id user_id stock_id count purchase_date
	 */

	private Long id;
	private Long userId;
	private Long count;
	private Date purchaseDate;
	private Long purchasePrice;
	private Long stockId;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(final Long count) {
		this.count = count;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(final Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(final Long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

}
