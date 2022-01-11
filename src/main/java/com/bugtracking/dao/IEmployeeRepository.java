package com.bugtracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.bean.Employee;

@Repository("er")
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
