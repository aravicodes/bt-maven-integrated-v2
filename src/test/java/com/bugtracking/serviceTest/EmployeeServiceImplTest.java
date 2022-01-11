package com.bugtracking.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.bean.Employee;
import com.bugtracking.dao.IEmployeeRepository;
import com.bugtracking.dto.EmployeeDto;
import com.bugtracking.mapper.EmployeeMapper;
import com.bugtracking.service.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

	@Mock
	IEmployeeRepository er;

	@InjectMocks
	EmployeeServiceImpl esi;

	@Mock
	EmployeeDto employeeDto;

	@Mock
	Employee employee;

	@Mock
	List<EmployeeDto> employeeDtol;

	@Mock
	List<Employee> employeel;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		employeeDto.setEmpId(12l);
		employeeDto.setEmpContactNo("1234");
		employeeDto.setEmpEmail("ssls");
		employeeDto.setEmpName("ss");
		employeeDto.setProjectId(11l);
		
	}

	@Test
	void testbugById() {
		Mockito.when(er.findById(12l)).thenReturn(Optional.of(employee));
		EmployeeDto empDto1 = EmployeeMapper.toEmployeeDto(employee);
		assertEquals(empDto1.getEmpId(), esi.getEmployee(12l).getEmpId());
		Mockito.verify(er, times(1)).findById(12l);
	}

	@Test
	void testAddBug() {
		when(er.save(any(Employee.class))).thenReturn(employee);
		EmployeeDto employeeDto1 = EmployeeMapper.toEmployeeDto(employee);
		EmployeeDto employeeDto2 = esi.createEmployee(employeeDto1);
		assertEquals(employeeDto2.getEmpId(), employeeDto2.getEmpId());
		verify(er, atLeast(1)).save(any(Employee.class));
	}

	@Test
	void testupdateBug() {
		when(er.existsById(12l)).thenReturn(true);
		when(er.save(any(Employee.class))).thenReturn(employee);
		EmployeeDto employeeDto1 = EmployeeMapper.toEmployeeDto(employee);
		assertEquals(employee.getEmpId(),esi.updateEmployee(12l, employeeDto1).getEmpId());
		verify(er, atLeast(1)).save(any(Employee.class));
	}

	@Test
	void testallbugs() {
		when(er.findAll()).thenReturn(employeel);
		List<EmployeeDto> employeeDtol = EmployeeMapper.toEmployeeDtoList(employeel);
		assertEquals(employeeDtol, esi.getAllEmployees());
		verify(er, times(1)).findAll();
	}


	@Test
	void testdeletebyid() {
		when(er.existsById(12l)).thenReturn(true);
		Mockito.when(er.getById(12l)).thenReturn(employee);
		assertEquals(employee.getEmpId(), esi.deleteEmployee(12l).getEmpId());
		verify(er, times(1)).existsById(12l);
	}

}
