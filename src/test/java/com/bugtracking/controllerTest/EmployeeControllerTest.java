package com.bugtracking.controllerTest;

import com.bugtracking.bean.Employee;
import com.bugtracking.controller.EmployeeController;
import com.bugtracking.dto.EmployeeDto;
import com.bugtracking.service.IEmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class EmployeeControllerTest {
	long empId;
	@Mock
	public EmployeeDto employeeDto;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		employeeDto.setEmpId(1);
		employeeDto.setEmpName("aravi");
		employeeDto.setEmpEmail("aravi@gmail.com");
		employeeDto.setEmpContactNo("8123456789");
		employeeDto.setProjectId(321);
	}

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	IEmployeeService employeeService;

	@Mock
	List<EmployeeDto> employeeDtolist;
	@Mock 
	Employee employee;

	@Test
	void testAddEmployee() 
	{
		Mockito.when(employeeService.createEmployee(employeeDto)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.createEmployee(employeeDto));
		Mockito.verify(employeeService).createEmployee(employeeDto);
	}


	@Test
	void updateEmployee() 
	{
		when(employeeService.updateEmployee(empId,employeeDto)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.updateEmployee(empId,employeeDto));
		verify(employeeService).updateEmployee(empId,employeeDto);
	}
	

	@Test
	void deleteEmployee() 
	{
		when(employeeService.deleteEmployee(12)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.deleteEmployee(12));
		verify(employeeService).deleteEmployee(12);

	}

	@Test
	void getEmployee() 
	{
		when(employeeService.getEmployee(empId)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.getEmployee(empId));
		verify(employeeService).getEmployee(empId);
	}
	
	@Test
	void getAllEmployee() {
		when(employeeService.getAllEmployees()).thenReturn(employeeDtolist);
		assertEquals(employeeDtolist,employeeController.getAllEmployees());
		verify(employeeService).getAllEmployees();
	}


}