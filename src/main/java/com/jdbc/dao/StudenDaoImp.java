package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jdbc.model.Student;

public class StudenDaoImp implements StudentDao {
	
	private static String DB_URL = "jdbc:mysql://localhost:3306/prueba_bd";
	private static String USER = "root";
	private static String PASSWORD = "admin";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Student st = null;
	

	@Override
	public String insert(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Student s, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
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
			PreparedStatement ps = this.con.prepareStatement(GET_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				st = new Student(rs.getInt("id"), rs.getString("student_name"), rs.getFloat("score"), rs.getInt("subject_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
	}

}
