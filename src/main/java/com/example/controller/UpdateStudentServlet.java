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

@WebServlet("/updateStudent")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UpdateStudentServlet extends HttpServlet {

	private StudentDao studentDao;

	@Override
	public void init() throws ServletException {
		super.init();
		studentDao = new StudentDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentID = request.getParameter("studentID");
		Student student = studentDao.getStudent(studentID);

		if (student != null) {
			request.setAttribute("student", student);
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Student not found.");
			request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentID = request.getParameter("studentID");
		String studentName = request.getParameter("studentName");
		String studentAddress = request.getParameter("studentAddress");
		String studentMobile = request.getParameter("studentMobile");

		// Fetching the existing student data
		Student student = studentDao.getStudent(studentID);

		// Update the attributes
		student.setStudentName(studentName);
		student.setStudentAddress(studentAddress);
		student.setStudentMobile(studentMobile);

		HashMap<String, Integer> marks = new HashMap<>();
		marks.put("computer", Integer.parseInt(request.getParameter("computer")));
		marks.put("physics", Integer.parseInt(request.getParameter("physics")));
		marks.put("chemistry", Integer.parseInt(request.getParameter("chemistry")));
		marks.put("biology", Integer.parseInt(request.getParameter("biology")));
		marks.put("english", Integer.parseInt(request.getParameter("english")));
		marks.put("math", Integer.parseInt(request.getParameter("math")));
		student.setMarks(marks);

		// photo upload logic
		Part filePart = request.getPart("photo");
		if (filePart != null && filePart.getSize() > 0) {
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			String uploadPath = getServletContext().getRealPath("/images"); // Save to webapp/images
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
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

		studentDao.updateStudent(student);
		response.sendRedirect("index.jsp");
	}
}
