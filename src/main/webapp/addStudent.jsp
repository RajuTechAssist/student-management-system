<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h2>Add New Student</h2>
			<img src="images/logo.png" alt="logo">
		</div>
		<form action="addStudent" method="post" enctype="multipart/form-data"
			class="form-container">
			<label>Student ID: <input type="text" name="studentID"
				required>
			</label> <label>Student Name: <input type="text" name="studentName"
				required>
			</label> <label>Student Address: <input type="text"
				name="studentAddress" required>
			</label> <label>Student Mobile: <input type="text"
				name="studentMobile" required>
			</label> <label>Computer Marks : <input type="number" name="computer"
				required>
			</label> <label>Physics Marks : <input type="number" name="physics"
				required>
			</label> <label>Chemistry Marks : <input type="number"
				name="chemistry" required>
			</label> <label>Biology Marks : <input type="number" name="biology"
				required>
			</label> <label>English Marks : <input type="number" name="english"
				required>
			</label> <label>Math Marks : <input type="number" name="math"
				required>
			</label> <label> Photo: <input type="file" name="photo"></label> <input
				type="submit" value="Add Student">
		</form>
		<div class="navigation">
			<a href="index.jsp">Back to Home</a>
		</div>
	</div>
	<div class="footer">
		<p>© 2024 CBSE | All rights reserved</p>
	</div>
</body>
</html>