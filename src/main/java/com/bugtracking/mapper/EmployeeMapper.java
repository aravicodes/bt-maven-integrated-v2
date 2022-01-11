package com.bugtracking.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.bugtracking.bean.Employee;
import com.bugtracking.dto.EmployeeDto;

public class EmployeeMapper {
	
	public static Employee toEmployee(EmployeeDto employeeDto) {
		Employee employee=new Employee();
		employee.setEmpId(employeeDto.getEmpId());
		employee.setEmpName(employeeDto.getEmpName());
		employee.setEmpEmail(employeeDto.getEmpEmail());
		employee.setEmpContactNo(employeeDto.getEmpContactNo());
		employee.setProjectId(employeeDto.getProjectId());
		return employee;
	}
	
	public static EmployeeDto toEmployeeDto(Employee employee) {
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setEmpId(employee.getEmpId());
		employeeDto.setEmpName(employee.getEmpName());
		employeeDto.setEmpEmail(employee.getEmpEmail());
		employeeDto.setEmpContactNo(employee.getEmpContactNo());
		employeeDto.setProjectId(employee.getProjectId());
		return employeeDto;
	}
	
	public static List<EmployeeDto> toEmployeeDtoList(List<Employee> employees){
		return employees.stream().map(EmployeeMapper::toEmployeeDto).collect(Collectors.toList());
	}

}