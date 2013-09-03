package org.yogocodes.bikewars.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("userProfileUpdateTask")
public class UserProfileUpdateTask {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final Logger log = LoggerFactory.getLogger(UserProfileUpdateTask.class);

	public UserProfileUpdateTask() {
		log.info("user profile update task initialized");
	}

	// Query
	// update user_profile set energy = if( energy + energy_inc < max_energy,
	// energy+energy_inc, max_energy ) where energy < max_energy ;

	@Scheduled(fixedRate = 60000, initialDelay = 30000)
	public void updateEnergies() {
		log.info("updating user energies");
		final String sql = "update user_profile set energy = if( energy + energy_inc < max_energy, energy+energy_inc, max_energy ), modified=now() where energy < max_energy";

		jdbcTemplate.update(sql);

		log.info("updated user energies");

	}

	@Scheduled(fixedRate = 60000, initialDelay = 60000)
	public void updateHealth() {
		log.info("updating user health");
		final String sql = "update user_profile set health = if( health + health_inc < max_health, health + health_inc, max_health ), modified=now()  where health < max_health";

		jdbcTemplate.update(sql);

		log.info("updated user healths");

	}
}
