package org.yogocodes.bikewars.model;

import java.util.Date;

/*
 * create table user_jobs (
 id integer not null auto_increment,
 name varchar(255),
 description varchar(255),
 income integer,
 energy integer,
 created timestamp,
 modified timestamp,
 primary key(id)
 ) ENGINE =InnoDB;

 */
public class JobModel {
	private Integer jobId;
	private String name;
	private String description;
	private Integer income;
	private Integer energy;
	private Date created;
	private Date modified;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(final Integer jobId) {
		this.jobId = jobId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(final Integer income) {
		this.income = income;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(final Integer energy) {
		this.energy = energy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(final Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(final Date modified) {
		this.modified = modified;
	}

}
