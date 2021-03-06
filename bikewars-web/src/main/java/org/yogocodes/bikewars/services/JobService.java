package org.yogocodes.bikewars.services;

import java.util.List;

import org.yogocodes.bikewars.model.JobModel;

public interface JobService {

	List<JobModel> getAllJobs(Integer pageNum, Integer pageSize);

	JobModel getJobById(Long jobId);

	void executeJob(Long userId, Long jobId);

}
