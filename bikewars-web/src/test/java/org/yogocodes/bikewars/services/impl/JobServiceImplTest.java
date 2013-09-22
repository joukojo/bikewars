package org.yogocodes.bikewars.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.yogocodes.bikewars.dao.JobDao;
import org.yogocodes.bikewars.model.JobModel;

@RunWith(MockitoJUnitRunner.class)
public class JobServiceImplTest {
	@Mock
	private JobDao jobDao;
	@InjectMocks
	private JobServiceImpl jobServiceImpl;

	@Test
	public void testGetAllJobs() throws Exception {

		final List<JobModel> jobs = new ArrayList<>();
		Mockito.when(jobDao.getJobs()).thenReturn(jobs);

		final List<JobModel> actualJobs = jobServiceImpl.getAllJobs(0, 100);

		Assert.assertEquals("jobs are different", jobs, actualJobs);
	}

	@Test
	public void testGetJobById() throws Exception {

		final Long jobId = System.currentTimeMillis();
		final JobModel job = new JobModel();
		job.setJobId(jobId.intValue());
		Mockito.when(jobDao.getJobById(jobId)).thenReturn(job);

		final JobModel actualJob = jobServiceImpl.getJobById(jobId);

		Assert.assertEquals("job is different", job, actualJob);
	}

}
