package com.bugtracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.bean.Project;

@Repository("rs")
public interface IProjectRepository extends JpaRepository<Project, Long>{

}
