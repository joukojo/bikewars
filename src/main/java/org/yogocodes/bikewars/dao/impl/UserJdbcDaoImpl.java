package org.yogocodes.bikewars.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.UserDao;

@Repository("userDao")
public class UserJdbcDaoImpl implements UserDao {

	private final Logger log = LoggerFactory.getLogger(UserJdbcDaoImpl.class); 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	} 
	
	
	
	
}
