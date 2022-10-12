package com.jdbc.dto;

public class DetalleStudentDto {

	
	String student_name;
	float score;
	String name;
	
	
	public DetalleStudentDto() {
		super();
	}


	public DetalleStudentDto(String student_name, float score, String name) {
		super();
		this.student_name = student_name;
		this.score = score;
		this.name = name;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public float getScore() {
		return score;
	}


	public void setScore(float score) {
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
