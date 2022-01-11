package com.bugtracking.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.bean.Employee;
import com.bugtracking.dao.IEmployeeRepository;
import com.bugtracking.dto.EmployeeDto;
import com.bugtracking.exceptions.IdNotFoundException;
import com.bugtracking.mapper.EmployeeMapper;

@Service("es")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	IEmployeeRepository er;

	@Override
	public EmployeeDto createEmployee(EmployeeDto e) {
		Employee empObj = EmployeeMapper.toEmployee(e);
		Employee emp = er.save(empObj);
		return EmployeeMapper.toEmployeeDto(emp);
	}

	@Override
	public EmployeeDto updateEmployee(long empId,EmployeeDto e) {
		// TODO Auto-generated method stub
		if(er.existsById(empId)) {
			Employee empObj = EmployeeMapper.toEmployee(e);
			//System.out.println(empObj.());
			Employee emp = er.save(empObj);
			return EmployeeMapper.toEmployeeDto(emp);
			}
			else {
				throw new IdNotFoundException("Provided id is not there");
			}
	}

	@Override
	public EmployeeDto deleteEmployee(long empId) {
		if (er.existsById(empId)) {
			EmployeeDto empDto = EmployeeMapper.toEmployeeDto(er.getById(empId));
			er.deleteById(empId);
			return empDto;
		} else
			throw new IdNotFoundException("id not found");
	}

	@Override
	public EmployeeDto getEmployee(long empId) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = er.findById(empId);
		if (emp.isPresent())
			return EmployeeMapper.toEmployeeDto(emp.get());
		else
			throw new IdNotFoundException("id not found");

	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> empDto = EmployeeMapper.toEmployeeDtoList(er.findAll());
		return empDto;
	
	}

}
