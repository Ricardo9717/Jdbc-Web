package com.jdbc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.dao.StudenDaoImp;
import com.jdbc.dao.StudentDao;
import com.jdbc.dto.DetalleStudentDto;
import com.jdbc.model.Student;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	
	
	private StudentDao sDao = new StudenDaoImp();
	private StudenDaoImp dto = new StudenDaoImp(); 
	
	@GetMapping("/getAll")
	public List<Student>getStudents(){
		return sDao.getAll();
		
	}
	
	@GetMapping("/getById{id}")
	public Student getStudentById(@PathVariable("id")int id){
		
		return sDao.getById(id);
		
	}
	
	@DeleteMapping("/deleteById{id}")
	public String deleteStudentById(@PathVariable("id")int id){
		
		return sDao.delete(id);
		
	}
	
	@PostMapping("/insert")
    public String insertSubjects (@RequestBody Student s){
        
		return sDao.insert(s);
    }
	
	@PatchMapping("/update{id}")
    public String updatetSubjects (@RequestBody Student s, @PathVariable("id")int id){
        
		return sDao.update(s, id);
    }
	
	@GetMapping("/getDetalle")
	public List<DetalleStudentDto>getStudentsDetalle(){
		return dto.getDetalle();
		
	}
	
	

}

