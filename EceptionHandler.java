package com.jsp.courses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.courses.util.ResponseStructure;
@RestControllerAdvice
public class EceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> idnotfound(IdNotFound ex) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("course not found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

}
