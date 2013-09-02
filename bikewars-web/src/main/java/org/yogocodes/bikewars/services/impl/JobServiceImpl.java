package org.yogocodes.bikewars.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yogocodes.bikewars.dao.JobDao;
import org.yogocodes.bikewars.model.JobModel;
import org.yogocodes.bikewars.model.UserInfoModel;
import org.yogocodes.bikewars.services.JobService;
import org.yogocodes.bikewars.services.UserInfoService;

@Service("jobService")
public class JobServiceImpl implements JobService {

	private final Logger log = LoggerFactory.getLogger(JobServiceImpl.class);

	@Autowired
	private UserInfoService userService;

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

	@Override
	public void executeJob(final Long userId, final Long jobId) {
		final JobModel job = getJobById(jobId);
		final UserInfoModel userInfo = userService.getUserInfo(userId);

		userInfo.setCash(userInfo.getCash() + job.getIncome());
		userInfo.setEnergy(userInfo.getEnergy() - job.getEnergy());

		userService.saveUserInfo(userInfo);
	}

}
