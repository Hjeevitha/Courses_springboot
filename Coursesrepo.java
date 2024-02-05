package com.jsp.courses.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.courses.dto.Courses;

public interface Coursesrepo extends JpaRepository<Courses, Integer>{
	
	
	

}
