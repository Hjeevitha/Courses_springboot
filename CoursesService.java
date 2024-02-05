package com.jsp.courses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.courses.dao.CousesDao;
import com.jsp.courses.dto.Courses;
import com.jsp.courses.exception.IdNotFound;
import com.jsp.courses.util.ResponseStructure;

@Service
public class CoursesService {
	@Autowired
	 private CousesDao cousesDao;
	
	public ResponseEntity<ResponseStructure<Courses>> saveCourses(Courses courses) {
		Courses courses2=cousesDao.saveCourses(courses);
		ResponseStructure<Courses> responseStructure=new ResponseStructure<Courses>();
		responseStructure.setMessage("data saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(courses2);
		return new ResponseEntity<ResponseStructure<Courses>>(responseStructure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Courses>> updateCourses(int id,Courses courses) {
		Courses course=cousesDao.updateCourses(id,courses);
		if(course!=null) {
			ResponseStructure<Courses> responseStructure=new ResponseStructure<Courses>();
			responseStructure.setMessage("data updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(course);
			return new ResponseEntity<ResponseStructure<Courses>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFound("course is not availble to update");
		}
	}
	
	public ResponseEntity<ResponseStructure<Courses>> findbyid(int id) {
		Courses courses=cousesDao.findByid(id);
		if(courses!=null) {
			ResponseStructure<Courses> responseStructure=new ResponseStructure<Courses>();
			responseStructure.setMessage("data found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(courses);
			return new ResponseEntity<ResponseStructure<Courses>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFound("course is not availble to fecth");
		}
	}
	
	public ResponseEntity<ResponseStructure<Courses>> deletebyid(int id) {
		Courses courses=cousesDao.deleteCursebyid(id);		
		if(courses!=null) {
			ResponseStructure<Courses> responseStructure=new ResponseStructure<Courses>();
			responseStructure.setMessage("data successfully deleted");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(courses);
			return new ResponseEntity<ResponseStructure<Courses>>(responseStructure,HttpStatus.FOUND);
			
		}else {
			throw new IdNotFound("course is not avilable to delete");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Courses>>> findall() {
		List<Courses> courses=cousesDao.findallcourses();
		if(courses!=null) {
			ResponseStructure<List<Courses>> responseStructure=new ResponseStructure<List<Courses>>();
			responseStructure.setMessage("data successfully fecthed");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(courses);
			return new ResponseEntity<ResponseStructure<List<Courses>>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFound("courses not exist");
		}
		
	}

}
