package com.bugtracking.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.bugtracking.bean.Project;
import com.bugtracking.dto.ProjectDto;

public class ProjectMapper {
	
	public static Project toProject(ProjectDto projectDto) {
		Project project=new Project();
		project.setProjId(projectDto.getProjId());
		project.setProjname(projectDto.getProjName());
		project.setProjstatus(projectDto.getProjStatus());
		project.setMembers(projectDto.getMembers());
		return project;
	}
	
	public static ProjectDto toProjectDto(Project project) {
		ProjectDto projectDto=new ProjectDto();
		projectDto.setProjId(project.getProjId());
		projectDto.setProjName(project.getProjname());
		projectDto.setProjStatus(project.getProjstatus());
		projectDto.setMembers(project.getMembers());;
		return projectDto;
	}
	
	public static List<ProjectDto> toProjectDtoList(List<Project> projects){
		return projects.stream().map(ProjectMapper::toProjectDto).collect(Collectors.toList());
	}

}