package org.yogocodes.bikewars.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.yogocodes.bikewars.model.JobModel;

public class JobRowMapper implements RowMapper<JobModel> {

	@Override
	public JobModel mapRow(final ResultSet rs, final int rowNum) throws SQLException {

		final Date created = rs.getDate("created");
		final String description = rs.getString("description");
		final Integer energy = rs.getInt("energy");
		final Integer income = rs.getInt("income");
		final Integer jobId = rs.getInt("id");
		final Date modified = rs.getDate("modified");
		final String name = rs.getString("name");

		final JobModel jobModel = new JobModel();
		jobModel.setName(name);
		jobModel.setModified(modified);
		jobModel.setJobId(jobId);
		jobModel.setIncome(income);
		jobModel.setEnergy(energy);
		jobModel.setDescription(description);
		jobModel.setCreated(created);

		return jobModel;
	}

}
