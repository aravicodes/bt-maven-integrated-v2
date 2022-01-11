package com.bugtracking.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bugtracking.bean.Bug;
import com.bugtracking.bean.Employee;
import com.bugtracking.bean.Project;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class AdminController {
	RestTemplate rt = new RestTemplate();

	@ApiOperation("Used to create employee(BY ADMIN)")
	@PostMapping("/admin/employees")
	public String createEmployee(@Valid @RequestBody Employee e) {
		String endpoint = "http://localhost:8054/employees/";
		rt.postForLocation(endpoint, e);
		return "created successfully";
	}

	@ApiOperation("Used to fetch employee with particular id(BY ADMIN)")
	@GetMapping("/admin/employees/{empId}")
	public Employee getEmployee(@PathVariable long empId) {
		String endpoint = "http://localhost:8054/employees/" + empId;
		return rt.getForObject(endpoint, Employee.class);
	}

	@ApiOperation("Used to fetch all employees(BY ADMIN)")
	@GetMapping("/admin/employees")
	public List<Employee> getAllEmployees() {
		String endpoint = "http://localhost:8054/employees/";
		List<Employee> m = Arrays.asList(rt.getForObject(endpoint, Employee[].class));
		return m;
	}

	@ApiOperation("Used to update employees(BY ADMIN)")
	@PutMapping("/admin/employees/{empId}")
	public String updateEmployee(@PathVariable("empId") long empId, @Valid @RequestBody Employee e) {
		String endpoint = "http://localhost:8054/employees/" + empId;
		rt.put(endpoint, e);
		return "updated successfully";
	}

	@ApiOperation("Used to delete employee with particular id(BY ADMIN)")
	@DeleteMapping("/admin/employees/{empId}")
	public String deleteEmployee(@PathVariable long empId) {
		String endpoint = "http://localhost:8054/employees/" + empId;
		rt.delete(endpoint);
		return "deleted";
	}

	@ApiOperation("Used to create project(BY ADMIN)")
	@PostMapping("/admin/projects")
	public String createProject(@Valid @RequestBody Project p) {
		String endpoint = "http://localhost:8054/projects/";
		rt.postForLocation(endpoint, p);
		return "created successfully";
	}

	@ApiOperation("Used to fetch project with particular id(BY ADMIN)")
	@GetMapping("/admin/projects/{projId}")
	public Project getProject(@PathVariable long projId) {
		String endpoint = "http://localhost:8054/projects/" + projId;
		return rt.getForObject(endpoint, Project.class);
	}

	@ApiOperation("Used to fetch all projects(BY ADMIN)")
	@GetMapping("/admin/projects")
	public List<Project> getAllProjects() {
		String endpoint = "http://localhost:8054/projects/";
		return Arrays.asList(rt.getForObject(endpoint, Project[].class));

	}

	@ApiOperation("Used to update project(BY ADMIN)")
	@PutMapping("/admin/projects/{projId}")
	public String updateProject(@PathVariable("projId") long projId, @Valid @RequestBody Project p) {
		String endpoint = "http://localhost:8054/projects/" + projId;
		rt.put(endpoint, p);
		return "updated successfully";
	}

	@ApiOperation("Used to delete project with particular id(BY ADMIN)")
	@DeleteMapping("/admin/projects/{projId}")
	public String deleteProject(@PathVariable long projId) {
		String endpoint = "http://localhost:8054/projects/" + projId;
		rt.delete(endpoint);
		return "deleted";
	}

	@ApiOperation("Used to create bug(BY ADMIN)")
	@PostMapping("/admin/bugs")
	public String createBug(@Valid @RequestBody Bug b) {
		String endpoint = "http://localhost:8054/bugs/";
		rt.postForLocation(endpoint, b);
		return "created successfully";

	}

	@ApiOperation("Used to fetch bug with particular id(BY ADMIN)")
	@GetMapping("/admin/bugs/{bugId}")
	public Bug getBug(@PathVariable long bugId) {
		String endpoint = "http://localhost:8054/bugs/" + bugId;
		return rt.getForObject(endpoint, Bug.class);
	}

	@GetMapping("/admin/bugs")
	@ApiOperation("used to fetch all bugs(BY ADMIN)")
	public List<Bug> getAllBugs() {
		String endpoint = "http://localhost:8054/bugs/";
		List<Bug> m = Arrays.asList(rt.getForObject(endpoint, Bug[].class));
		return m;
	}

	@ApiOperation("Used to update bug(BY ADMIN)")
	@PutMapping("/admin/bugs/{bugId}")
	public String updateBug(@PathVariable long bugId, @Valid @RequestBody Bug b) {
		String endpoint = "http://localhost:8054/bugs/" + bugId;
		rt.put(endpoint, b);
		return "updated successfully";
	}

	@ApiOperation("Used to delete bug with particular id(BY ADMIN)")
	@DeleteMapping("/admin/bugs/{bugId}")
	public String deleteBug(@PathVariable long bugId) {
		String endpoint = "http://localhost:8054/bugs/" + bugId;
		rt.delete(endpoint);
		return "deleted";
	}

	@ApiOperation("Used to fetch bugs by status(BY ADMIN)")
	@GetMapping("/admin/bystatus/{bugStatus}")
	public List<Bug> bugsByStatus(@PathVariable String bugStatus) {
		String endpoint = "http://localhost:8054/bugs/bystatus/" + bugStatus;
		List<Bug> m = Arrays.asList(rt.getForObject(endpoint, Bug[].class));
		return m;
	}
}
