package com.qaitdevlabs.qualityassessor.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: anujchhabra
 * Date: 28/8/12
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkExperience {
    private Long workExperienceId;
    private User user;
    private String title;
    private String areaOfExpertise;
    private Date fromDate;
    private Date toDate;
    private String roleDescription;
    
    public Long getWorkExperienceId() {
        return workExperienceId;
    }

    public void setWorkExperienceId(Long workExperienceId) {
        this.workExperienceId = workExperienceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
