package com.jdbc.model;

public class Student {
	
	int id;
	String student_name;
	float score;
	int subject_id;
	
	
	public Student() {
		super();
	}


	public Student(String student_name, float score, int subject_id) {
		super();
		this.student_name = student_name;
		this.score = score;
		this.subject_id = subject_id;
	}
	
	
	public Student(int id, String student_name, float score, int subject_id) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.score = score;
		this.subject_id = subject_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	
	
	
	

}
