package com.example.controller;

import java.io.IOException;
import java.util.HashMap;

import com.example.dao.StudentDao;
import com.example.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {
	private StudentDao studentDao;

	 @Override
	 public void init() throws ServletException {
	     super.init();
	     studentDao = new StudentDao();
	 }

	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String studentID = request.getParameter("studentID");

	     Student student = studentDao.getStudent(studentID);
	     System.out.println(student);

	     if (student != null) {
	         request.setAttribute("student", student);
	         double percentage = calculatePercentage(student.getMarks());
	         request.setAttribute("percentage",percentage);
	         request.getRequestDispatcher("searchStudent.jsp").forward(request, response);
	     } else {
	         request.setAttribute("errorMessage", "Student not found.");
	         request.getRequestDispatcher("searchStudent.jsp").forward(request, response);
	     }
	 }
	     private double calculatePercentage(HashMap<String, Integer> marks) {
	         int totalMarks = 0;
	         for (int mark : marks.values()) {
	             totalMarks += mark;
	         }
	         if (marks.size() > 0) {
	             return (double) totalMarks / marks.size();
	         }
	         return 0.0;
	     }
	     
	     
}
