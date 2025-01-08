package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.example.model.Student;

public class StudentDao {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "Ra123@123@123@";
	 
	 private static Map<String, Student> studentMap = new HashMap<>();
	 
	 public void addStudent(Student student) {
	        String sql = "INSERT INTO students (studentID, studentName, studentAddress, studentMobile, photoPath) VALUES (?, ?, ?, ?, ?)";
	        String marksSql = "INSERT INTO marks (studentID, subject, marks) VALUES (?, ?, ?)";

	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             PreparedStatement marksStmt = conn.prepareStatement(marksSql)) {

	            conn.setAutoCommit(false); // start transaction


	            pstmt.setString(1, student.getStudentID());
	            pstmt.setString(2, student.getStudentName());
	            pstmt.setString(3, student.getStudentAddress());
	            pstmt.setString(4, student.getStudentMobile());
	             pstmt.setString(5, student.getPhotoPath());
	            pstmt.executeUpdate();

	            HashMap<String,Integer> marks = student.getMarks();
	             for(Map.Entry<String, Integer> entry : marks.entrySet()){
	                marksStmt.setString(1, student.getStudentID());
	                marksStmt.setString(2, entry.getKey());
	                marksStmt.setInt(3, entry.getValue());
	                marksStmt.executeUpdate();
	             }
	          conn.commit();
	          conn.setAutoCommit(true); //end transaction
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }


	    public Student getStudent(String studentID) {
	        String sql = "SELECT * FROM students WHERE studentID = ?";
	        String marksSql = "SELECT subject, marks FROM marks WHERE studentID = ?";
	        Student student = null;
	         try (Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(sql);
	                PreparedStatement marksStmt = conn.prepareStatement(marksSql)) {

	             pstmt.setString(1,studentID);
	              ResultSet rs = pstmt.executeQuery();
	            if(rs.next()){
	                student = new Student(rs.getString("studentID"),
	                                     rs.getString("studentName"),
	                                     rs.getString("studentAddress"),
	                                     rs.getString("studentMobile"));
	                 student.setPhotoPath(rs.getString("photoPath"));
	                 HashMap<String,Integer> marks = new HashMap<>();
	                 marksStmt.setString(1,studentID);
	                 ResultSet marksRs = marksStmt.executeQuery();
	                 while (marksRs.next()){
	                     marks.put(marksRs.getString("subject"), marksRs.getInt("marks"));
	                 }
	                 student.setMarks(marks);

	              }

	         } catch (SQLException e) {
	             e.printStackTrace();
	            System.out.println(e.getMessage());
	         }
	       return student;
	     }

	    public void deleteStudent(String studentID) {
	        String sql = "DELETE FROM students WHERE studentID = ?";
	         String marksSql = "DELETE FROM marks WHERE studentID = ?";

	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             PreparedStatement marksStmt = conn.prepareStatement(marksSql)) {
	            marksStmt.setString(1,studentID);
	             pstmt.setString(1,studentID);
	             marksStmt.executeUpdate();
	            pstmt.executeUpdate();


	        } catch (SQLException e) {
	            e.printStackTrace();
	             System.out.println(e.getMessage());
	        }
	    }

	    public void updateStudent(Student student) {
	       String sql = "UPDATE students SET studentName = ?, studentAddress = ?, studentMobile = ?, photoPath = ? WHERE studentID = ?";
	       String deleteMarks = "DELETE FROM marks WHERE studentID = ?";
	       String marksSql = "INSERT INTO marks (studentID, subject, marks) VALUES (?, ?, ?)";

	        try (Connection conn = getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(sql);
	             PreparedStatement deleteStmt = conn.prepareStatement(deleteMarks);
	             PreparedStatement marksStmt = conn.prepareStatement(marksSql)) {

	            conn.setAutoCommit(false);

	             pstmt.setString(1, student.getStudentName());
	             pstmt.setString(2, student.getStudentAddress());
	             pstmt.setString(3, student.getStudentMobile());
	            pstmt.setString(4, student.getPhotoPath());
	             pstmt.setString(5, student.getStudentID());
	            pstmt.executeUpdate();

	             deleteStmt.setString(1,student.getStudentID());
	             deleteStmt.executeUpdate();

	            HashMap<String,Integer> marks = student.getMarks();
	            for(Map.Entry<String, Integer> entry : marks.entrySet()){
	                marksStmt.setString(1, student.getStudentID());
	                marksStmt.setString(2, entry.getKey());
	                marksStmt.setInt(3, entry.getValue());
	                marksStmt.executeUpdate();
	             }
	            conn.commit();
	           conn.setAutoCommit(true);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }


	     private Connection getConnection() throws SQLException {
	         try {
	             Class.forName("com.mysql.cj.jdbc.Driver");
	         } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	             System.out.println(e.getMessage());
	             throw new SQLException("MySQL JDBC Driver not found", e);
	         }
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	     }
}
