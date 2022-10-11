package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Student;

public interface StudentDao {
	
	String insert (Student s);
	String update (Student s, int id);
	String delete (int id);
	List<Student> getAll ();
	Student getById(int id);
	

}
