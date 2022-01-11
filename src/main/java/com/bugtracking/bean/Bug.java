package com.bugtracking.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel("Bug Entity")
public class Bug {
	@Id
	@Min(value = 1, message = "value must atleast be 1")
	private long bugId;
	@NotEmpty
	@ApiModelProperty("Bug description should not be empty")
	private String bugDescription;
	@NotEmpty
	@ApiModelProperty("Bug status should not be empty")
	private String bugStatus;
	private Date startDate;
	private Date endDate;
	@ManyToOne
	private Employee employee;
	@NotEmpty
	@ApiModelProperty("Bug Type should not be empty")
	private String bugType;
	@NotEmpty
	@ApiModelProperty("Bug Priority should not be empty")
	private String bugPriority;
	@ManyToOne
	private Project project;

	public long getBugId() {
		return bugId;
	}

	public void setBugId(long bugId) {
		this.bugId = bugId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public Bug(long bugId, String bugDescription, String bugStatus, Date startDate, Date endDate, Employee employee,
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

	public Bug() {

	}
}
