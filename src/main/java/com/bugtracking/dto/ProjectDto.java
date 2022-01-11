package com.bugtracking.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bugtracking.bean.Employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Project Entity")
public class ProjectDto
{
	@NotNull
	private long projId;
	@NotEmpty
	@ApiModelProperty("name should not empty")
	private String projName;
	@NotEmpty
	private String projStatus;
	@OneToMany
	private List<Employee> members;
	
	public List<Employee> getMembers() {
		return members;
	}
	public void setMembers(List<Employee> members) {
		this.members = members;
	}
	public long getProjId() {
		return projId;
	}
	public void setProjId(long projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projname) {
		this.projName = projname;
	}
	
	public String getProjStatus() {
		return projStatus;
	}
	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}
	
	public ProjectDto() {		
	}
	
	public ProjectDto(long projId, String projName, List<Employee> members, String projStatus) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.members = members;
		this.projStatus = projStatus;
	}
}