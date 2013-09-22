package org.yogocodes.bikewars.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class FightResultModel {
	private Long fight; 
	private Date created; 
	private Long attackerId; 
	private Long defenderId;
	private boolean isAttackerWon; 
	private Long money; 
	
	public Long getFight() {
		return fight;
	}
	public void setFight(Long fight) {
		this.fight = fight;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Long getAttackerId() {
		return attackerId;
	}
	public void setAttackerId(Long attackerId) {
		this.attackerId = attackerId;
	}
	public Long getDefenderId() {
		return defenderId;
	}
	public void setDefenderId(Long defenderId) {
		this.defenderId = defenderId;
	}
	public boolean isAttackerWon() {
		return isAttackerWon;
	}
	public void setAttackerWon(boolean isAttackerWon) {
		this.isAttackerWon = isAttackerWon;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this);
	}
}
