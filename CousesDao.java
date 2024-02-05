package com.jsp.courses.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.courses.dto.Courses;
import com.jsp.courses.exception.IdNotFound;
import com.jsp.courses.repo.Coursesrepo;

@Repository
public class CousesDao {
	@Autowired
	private Coursesrepo repo;
	
	public Courses saveCourses(Courses courses) {
		return repo.save(courses);
	}
	
	public Courses updateCourses(int id,Courses courses) {
		Optional<Courses> dbcourses=repo.findById(id);
		if(dbcourses.isPresent()) {
			courses.setId(id);
			return repo.save(courses);
		}else {
			return null;
		}
		
	}
	
	public Courses findByid(int id) {
		Optional<Courses> dbcourses=repo.findById(id);
		if(dbcourses.isPresent()) {
			return dbcourses.get();
		}else {
			return null;
		}
	}
	
	public List<Courses> findallcourses() {
		return repo.findAll();
	}
	
	public Courses deleteCursebyid(int id) {
		Optional<Courses> dbcourse=repo.findById(id);
		if(dbcourse.isPresent()) {
			Courses course=dbcourse.get();
			 repo.deleteById(id);
			 return course;
		}else {
			return null;
		}
	}


}
