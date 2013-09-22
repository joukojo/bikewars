package org.yogocodes.bikewars.web.personal;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yogocodes.bikewars.model.JobModel;
import org.yogocodes.bikewars.services.JobService;
import org.yogocodes.bikewars.util.UserSessionUtil;

@Controller
public class JobController {

	private final Logger log = LoggerFactory.getLogger(JobController.class);

	@Autowired
	private JobService jobService;

	@RequestMapping(value = "/personal/jobs", method = RequestMethod.GET)
	public String view(final Model model) {
		log.trace("view jobs");

		final List<JobModel> jobs = jobService.getAllJobs(0, 100);

		model.addAttribute("jobs", jobs);
		return "personal/jobs";
	}

	@RequestMapping(value = "/json/jobs/{jobId}", method = RequestMethod.GET)
	@ResponseBody
	public JobModel viewJob(@PathVariable final Long jobId) {
		log.trace("viewing job #{}", jobId);
		final JobModel job = getJobService().getJobById(jobId);
        log.trace("viewing job #{} - {}", jobId, job);
		return job;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(final JobService jobService) {
		this.jobService = jobService;
	}

	@RequestMapping(value = "/personal/json/jobs/{jobId}", method = RequestMethod.POST)
	@ResponseBody
	public JobModel executeJob(@PathVariable final Long jobId, final HttpSession httpSession) {
		log.trace("executing job #{}", jobId);
		final JobModel job = getJobService().getJobById(jobId);
		final Long userId = UserSessionUtil.getUserId(httpSession);
		jobService.executeJob(userId, jobId);
		return job;
	}

}
