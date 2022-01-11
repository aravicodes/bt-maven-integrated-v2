package com.bugtracking.dto;

import java.sql.Date;

import com.bugtracking.bean.Employee;
import com.bugtracking.bean.Project;


public class BugDto {
	private long bugId;
	private String bugDescription;
	private String bugStatus;
	private Date startDate;
	private Date endDate;
	private Employee employee;
	private String bugType;
	private String bugPriority;
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getBugId() {
		return bugId;
	}

	public void setBugId(long bugId) {
		this.bugId = bugId;
	}

	public String getBugDescription() {
		return bugDescription;
	}

	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}

	public String getBugStatus() {
		return bugStatus;
	}

	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBugType() {
		return bugType;
	}

	public void setBugType(String bugType) {
		this.bugType = bugType;
	}

	public String getBugPriority() {
		return bugPriority;
	}

	public void setBugPriority(String bugPriority) {
		this.bugPriority = bugPriority;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public BugDto(long bugId, String bugDescription, String bugStatus, Date startDate, Date endDate, Employee employee,
			String bugType, String bugPriority, Project project) {
		super();
		this.bugId = bugId;
		this.bugDescription = bugDescription;
		this.bugStatus = bugStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bugType = bugType;
		this.bugPriority = bugPriority;
		this.employee = employee;
		this.project = project;
	}

	public BugDto() {

	}
}
