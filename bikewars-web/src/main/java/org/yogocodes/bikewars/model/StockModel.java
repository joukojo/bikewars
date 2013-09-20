package org.yogocodes.bikewars.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * create table stocks ( id integer not null auto_increment, name varchar(255),
 * description text, current_price integer, primary key(id) )ENGINE = InnoDB;
 * 
 * @author joukojo
 * 
 */
public class StockModel {
	private Long stockId;
	private String name;
	private String description;
	private Long currentPrice;
	private Date created;
	private Date modified;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(final Long stockId) {
		this.stockId = stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(final Long currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(final Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(final Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this);
	}
}
