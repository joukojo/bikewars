package org.yogocodes.bikewars.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.JobDao;
import org.yogocodes.bikewars.model.JobModel;

@Repository("jobDao")
public class JobJdbcDaoImpl implements JobDao {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<JobModel> getJobs() {
		log.trace("get all jobs");
		final JobRowMapper jobRowMapper = new JobRowMapper();
		final String sql = "select * from user_jobs";

		return jdbcTemplate.query(sql, jobRowMapper);
	}

	@Override
	public JobModel getJobById(final Long jobId) {
		log.trace("get job #{}", jobId);
		final JobRowMapper jobRowMapper = new JobRowMapper();
		final Object params[] = { jobId };
		final String sql = "select * from user_jobs where id = ?";

		final List<JobModel> jobs = jdbcTemplate.query(sql, jobRowMapper, params);
		final JobModel job;
		if (jobs != null && !jobs.isEmpty()) {

			job = jobs.get(0);
			log.trace("job entity  found: {}", job);
		} else {
			job = null;
		}

		return job;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
