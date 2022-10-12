package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdbc.dto.DetalleStudentDto;
import com.jdbc.model.Student;

public class StudenDaoImp implements StudentDao {
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/prueba_bd";
	private static String USER = "root";
	private static String PASSWORD = "admin";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Student st = null;
	DetalleStudentDto dsd = null;
	String result;
	

	@Override
	public String insert(Student s) {
		String insert = "INSERT INTO student (student_name,score,subject_id) VALUES (?,?,?)";
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			ps = con.prepareStatement(insert);
			ps.setString(1, s.getStudent_name());
			ps.setFloat(2, s.getScore());
			ps.setInt(3,s.getSubject_id());
			int x = ps.executeUpdate();
			
			if(x>0) {
				result="1";
			}else {
				result="0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String update(Student s, int id) {
		String update = "UPDATE student SET student_name = ?, score = ?, subject_id = ? WHERE id = ?";
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			ps = con.prepareStatement(update);
			ps.setString(1, s.getStudent_name());
			ps.setFloat(2, s.getScore());
			ps.setInt(3,s.getSubject_id());
			ps.setInt(4,id);
			int x = ps.executeUpdate();
			
			if(x>0) {
				result="1";
			}else {
				result="0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String delete(int id) {
		String delete = "DELETE  FROM student WHERE id = ?";
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			int x = ps.executeUpdate();
			
			if(x>0) {
				result="1";
			}else {
				result="0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Student> getAll() {
		String GET_ALL = "SELECT * FROM student";
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			ps = con.prepareStatement(GET_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				st = new Student(rs.getInt("id"), rs.getString("student_name"), rs.getFloat("score"), rs.getInt("subject_id"));
				list.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student getById(int id) {
		String GET_BY_ID = "SELECT * FROM student WHERE id = ?";
		
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			ps = this.con.prepareStatement(GET_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				st = new Student(rs.getInt("id"), rs.getString("student_name"), rs.getFloat("score"), rs.getInt("subject_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
	}
	
	public List<DetalleStudentDto> getDetalle(){
		String DETALLE = "SELECT student_name, score, name FROM subject INNER JOIN student ON  subject.id = student.subject_id";
		ArrayList<DetalleStudentDto> list = new ArrayList<DetalleStudentDto>();
		
		try {
			con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			ps = con.prepareStatement(DETALLE);
			rs = ps.executeQuery();
			while(rs.next()) {
				dsd = new DetalleStudentDto(rs.getString("student_name"), rs.getFloat("score"), rs.getString("name"));
				list.add(dsd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}
