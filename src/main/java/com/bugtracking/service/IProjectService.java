package com.bugtracking.service;

import com.bugtracking.bean.Project;
import java.util.List;

public interface IProjectService {

	List<Project> getall();

	Project getproject(long projId);

	Project deleteproject(long projId);

	Project createproject(Project project);

	Project updateproject(long projId, Project p);

}
