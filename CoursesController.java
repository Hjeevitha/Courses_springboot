package com.jsp.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.jsp.courses.dao.CousesDao;
import com.jsp.courses.dto.Courses;
import com.jsp.courses.service.CoursesService;
import com.jsp.courses.util.ResponseStructure;

@RestController
public class CoursesController {
	@Autowired
	private CoursesService coursesService;
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Courses>> saveCourses(@RequestBody Courses courses) {
		return coursesService.saveCourses(courses);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Courses>> updateCourses(@RequestParam int id,@RequestBody Courses courses ) {
		return coursesService.updateCourses(id, courses);
		
	}
	
	@GetMapping("/find")
	
	public ResponseEntity<ResponseStructure<Courses>> findbyid(@RequestParam int id) {
		return coursesService.findbyid(id);
	}
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<Courses>>> findall() {
		return coursesService.findall();
	}
	@DeleteMapping("delete")
	public ResponseEntity<ResponseStructure<Courses>> delete(@RequestParam int id){
		return coursesService.deletebyid(id);
	}

}
