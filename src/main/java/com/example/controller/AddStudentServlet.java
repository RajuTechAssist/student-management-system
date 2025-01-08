package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import com.example.dao.StudentDao;
import com.example.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/addStudent")
@MultipartConfig(
     fileSizeThreshold = 1024 * 1024 * 2, // 2MB
     maxFileSize = 1024 * 1024 * 10,    // 10MB
     maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class AddStudentServlet extends HttpServlet {
	
	 private StudentDao studentDao;
	 
	 @Override
	 public void init() throws ServletException {
	     super.init();
	     studentDao = new StudentDao();
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 String studentID = request.getParameter("studentID");
		 String studentName = request.getParameter("studentName");
		 String studentAddress = request.getParameter("studentAddress");
		 String studentMobile = request.getParameter("studentMobile");
		 
		 Student student = new Student(studentID, studentName, studentAddress, studentMobile, null, null);
		 HashMap<String,Integer> marks = new HashMap<>();
		 
		 marks.put("computer",Integer.parseInt(request.getParameter("computer")));
	     marks.put("physics",Integer.parseInt(request.getParameter("physics")));
	     marks.put("chemistry",Integer.parseInt(request.getParameter("chemistry")));
	     marks.put("biology",Integer.parseInt(request.getParameter("biology")));
	     marks.put("english",Integer.parseInt(request.getParameter("english")));
	     marks.put("math",Integer.parseInt(request.getParameter("math")));

	     student.setMarks(marks);
	     
	     Part filePart = request.getPart("photo");
	     if(filePart != null && filePart.getSize() > 0) {
	    	 String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    	 
	    	 String uploadPath = getServletContext().getRealPath("/images");
	    	 
	    	 File uploadDir = new File(uploadPath);
	    	 
	    	 if(!uploadDir.exists()) {
	    		 uploadDir.mkdirs();
	    	 }
	    	 
	    	 String filePath = uploadPath + File.separator + fileName;
	    	 
	    	 try (InputStream fileContent = filePart.getInputStream()) {
	             Files.copy(fileContent, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
	         student.setPhotoPath("images/" + fileName);
	     }
	     studentDao.addStudent(student);
	     response.sendRedirect("index.jsp");

	 }
}
