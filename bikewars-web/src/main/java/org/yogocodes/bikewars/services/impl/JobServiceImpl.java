package org.yogocodes.bikewars.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.dao.JobDao;
import org.yogocodes.bikewars.model.JobModel;
import org.yogocodes.bikewars.services.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService {

	private final Logger log = LoggerFactory.getLogger(JobServiceImpl.class);

	@Autowired
	private JobDao jobDao;

	@Override
	public List<JobModel> getAllJobs(final Integer pageNum, final Integer pageSize) {
		log.trace("get all jobs for {} / {}", pageNum, pageSize);

		final List<JobModel> jobs = jobDao.getJobs();

		return jobs;
	}

	public JobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(final JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public JobModel getJobById(final Long jobId) {
		log.trace("getting job by id {}", jobId);
		return getJobDao().getJobById(jobId);
	}
}
