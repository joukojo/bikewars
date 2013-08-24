package org.yogocodes.bikewars.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserInfoModel {

	private Long userId;
	private String nickName;
	private Integer energy;
	private Integer energyIncrement;
	private Integer maxEnergy;
	private Integer cash;
	private Integer health;
	private Integer maxHealth;
	private Integer healthIncrement;
	private Date created;

	public Integer getHealth() {
		return health;
	}

	public void setHealth(final Integer health) {
		this.health = health;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(final Integer maxHealth) {
		this.maxHealth = maxHealth;
	}

	public Integer getHealthIncrement() {
		return healthIncrement;
	}

	public void setHealthIncrement(final Integer healthIncrement) {
		this.healthIncrement = healthIncrement;
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

	private Date modified;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(final String nickName) {
		this.nickName = nickName;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(final Integer energy) {
		this.energy = energy;
	}

	public Integer getEnergyIncrement() {
		return energyIncrement;
	}

	public void setEnergyIncrement(final Integer energyIncrement) {
		this.energyIncrement = energyIncrement;
	}

	public Integer getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(final Integer maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public Integer getCash() {
		return cash;
	}

	public void setCash(final Integer cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
