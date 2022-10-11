package com.jdbc.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.dao.StudenDaoImp;
import com.jdbc.dao.StudentDao;
import com.jdbc.model.Student;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	
	
	private StudentDao sDao = new StudenDaoImp();
	
	
	@GetMapping("/getAll")
	public List<Student>getStudents(){
		return sDao.getAll();
		
	}
	
	@GetMapping("/getById{id}")
	public Student getStudentById(@PathVariable("id")int id){
		return sDao.getById(id);
		
	}
	
	

}

