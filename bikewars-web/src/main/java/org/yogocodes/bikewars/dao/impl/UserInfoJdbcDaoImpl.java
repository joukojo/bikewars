package org.yogocodes.bikewars.dao.impl;

import java.util.List;

import org.perf4j.LoggingStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.UserInfoDao;
import org.yogocodes.bikewars.model.UserInfoModel;

@Repository("userInfoDao")
public class UserInfoJdbcDaoImpl implements UserInfoDao {
	private final Logger log = LoggerFactory.getLogger(UserInfoJdbcDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserInfoModel getUserInfo(final Long userId) {
		log.trace("getting userinfo for user {}", userId);
		final UserInfoRowMapper userInfoMapper = new UserInfoRowMapper();
		final Object params[] = { userId };
		final List<UserInfoModel> result = jdbcTemplate.query("select * from user_profile where id = ?", params, userInfoMapper);

		if (result == null || result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(final UserInfoModel userInfo) {
		final Object params[] = { userInfo.getCreated(), userInfo.getEnergyIncrement(), userInfo.getEnergy(), userInfo.getCash(), userInfo.getUserId() };
		jdbcTemplate.update("update user_profile set created = ?, energy_inc = ?, energy = ?, cash=? where id = ?", params);
	}

	@Override
	public List<UserInfoModel> getAttackbleUsers(int page, int pageSize) {

        LoggingStopWatch stopWatch = new LoggingStopWatch();
		int start= page*pageSize; 
		
		Object args[] = {start, pageSize};
		List<UserInfoModel> users = jdbcTemplate.query("select * from user_profile where health > 0.4 * max_health order by cash desc  limit ?,?", args,  new UserInfoRowMapper());

        stopWatch.stop("UserInfoJdbcDao", "got attackable users");
		return users;
	}

	
	@Override
	public List<UserInfoModel> getHighestUsers(){
		String sql = "select * from user_profile order by cash desc limit 5";
		
		List<UserInfoModel> highestusers = jdbcTemplate.query(sql, new UserInfoRowMapper());
		
		return highestusers;
	}
}
