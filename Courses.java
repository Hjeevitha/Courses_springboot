package com.jsp.courses.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Courses {
	@Id
	private int Id;
	private String CourseName;
	private double fees;
}
