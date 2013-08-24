package org.yogocodes.bikewars.services;

import java.util.List;

import org.yogocodes.bikewars.model.JobModel;

public interface JobService {

	List<JobModel> getAllJobs(Integer pageNum, Integer pageSize);

}
