package org.yogocodes.bikewars.dao;

import java.util.List;

import org.yogocodes.bikewars.model.JobModel;

public interface JobDao {

	List<JobModel> getJobs();

	JobModel getJobById(Long jobId);

}
