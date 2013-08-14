package org.yogocodes.bikewars.model;

public class UserInfoModel {

	private Long userId;
	private String nickName;
	private Integer energy;
	private Integer energyIncrement;
	private Integer maxEnergy;
	private Integer cash;

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
}
