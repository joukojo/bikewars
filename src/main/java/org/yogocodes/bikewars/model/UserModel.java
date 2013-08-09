package org.yogocodes.bikewars.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserModel {
	private Long userId;
	private String email;
	private String password; 
	private Date created; 
	private Date modified;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	} 
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
