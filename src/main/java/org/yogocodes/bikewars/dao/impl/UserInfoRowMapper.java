package org.yogocodes.bikewars.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.yogocodes.bikewars.model.UserInfoModel;

public class UserInfoRowMapper implements RowMapper<UserInfoModel> {

	@Override
	public UserInfoModel mapRow(final ResultSet rs, final int rowNum) throws SQLException {

		final Integer cash = rs.getInt("cash");
		final Integer energy = rs.getInt("energy");
		final Integer energyIncrement = rs.getInt("energy_inc");
		final Integer maxEnergy = rs.getInt("max_energy");
		final String nickName = rs.getString("nickname");
		final Long userId = rs.getLong("id");

		final UserInfoModel userInfo = new UserInfoModel();
		userInfo.setCash(cash);
		userInfo.setEnergy(energy);
		userInfo.setEnergyIncrement(energyIncrement);
		userInfo.setMaxEnergy(maxEnergy);
		userInfo.setNickName(nickName);
		userInfo.setUserId(userId);

		return userInfo;
	}
}
