<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h2>CBSE: Central Board of Secondary Education</h2>
			<img src="images/CbseLogo.png" alt="logo">
		</div>
		<h3>Student Management Dashboard: Update Students</h3>
		<c:if test="${not empty errorMessage}">
			<p class="error-message">${errorMessage}</p>
		</c:if>
		<c:if test="${not empty student}">
			<form action="updateStudent" method="post"
				enctype="multipart/form-data">
				<label>Student ID: <input type="number" name="studentID" value="${student.studentID}" required></label><br>
				<label>Student Name: <input type="text" name="studentName"
					value="${student.studentName}" required>
				</label> <br> <label>Student Address: <input type="text"
					name="studentAddress" value="${student.studentAddress}" required>
				</label> <br> <label>Student Mobile: <input type="text"
					name="studentMobile" value="${student.studentMobile}" required>
				</label> <br> <label>Computer Marks : <input type="number"
					name="computer" value="${student.marks.get('computer')}" required>
				</label> <br> <label>Physics Marks : <input type="number"
					name="physics" value="${student.marks.get('physics')}" required>
				</label> <br> <label>Chemistry Marks : <input type="number"
					name="chemistry" value="${student.marks.get('chemistry')}" required>
				</label> <br> <label>Biology Marks : <input type="number"
					name="biology" value="${student.marks.get('biology')}" required>
				</label> <br> <label>English Marks : <input type="number"
					name="english" value="${student.marks.get('english')}" required>
				</label> <br> <label>Math Marks : <input type="number"
					name="math" value="${student.marks.get('math')}" required>
				</label> <br> <label> Photo: <input type="file" name="photo"></label><br>
				<input type="submit" value="Update Student">
			</form>
		</c:if>
		<br>
		<div class="navigation">
			<a href="index.jsp">Back to Home</a>
		</div>
	</div>
	<div class="footer">
		<p>© 2024 CBSE | All rights reserved</p>
	</div>
</body>
</html>