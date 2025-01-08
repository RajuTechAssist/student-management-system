<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Student</title>
<link rel="stylesheet" href="css/styles.css">

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<h2>Search Student</h2>
			<img src="images/logo.png" alt="logo">
		</div>
		<form action="searchStudent" method="get" class="center">
			<label>Student ID: <input type="text" name="studentID"
				required>
			</label> <input type="submit" value="Search">
		</form>
		<br>
		<c:if test="${not empty student}">
			<c:if test="${not empty student.photoPath}">
				<div class="center">
					<img src="${student.photoPath}" alt="Student Photo"
						style="width: 200px; height: auto;">
				</div>
			</c:if>
			<p class="center">
				<strong>Student ID:</strong> ${student.studentID}
			</p>
			<p class="center">
				<strong>Student Name:</strong> ${student.studentName}
			</p>
			<p class="center">
				<strong>Address:</strong> ${student.studentAddress}
			</p>
			<p class="center">
				<strong>Mobile:</strong> ${student.studentMobile}
			</p>

			<h3 class="center">Marks:</h3>
			<table>
				<thead>
					<tr>
						<th>Subject</th>
						<th>Marks</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (request.getAttribute("student") != null) {
						com.example.model.Student student = (com.example.model.Student) request.getAttribute("student");
						if (student.getMarks() != null) {
							for (java.util.Map.Entry<String, Integer> entry : student.getMarks().entrySet()) {
					%>
					<tr>
						<td><%=entry.getKey()%></td>
						<td><%=entry.getValue()%></td>
					</tr>
					<%
					}
					}
					}
					%>
				</tbody>
			</table>
			<p class="center">
				<strong>Total Marks:</strong>
				<%
				if (request.getAttribute("student") != null) {
					com.example.model.Student student = (com.example.model.Student) request.getAttribute("student");
					if (student.getMarks() != null) {
						int totalMarks = 0;
						for (Integer mark : student.getMarks().values()) {
					totalMarks += mark;
						}
				%>
				<%=totalMarks%>
				<%
				} else {
				%>
				Marks not found
				<%
				}
				} else {
				%>
				Student not found
				<%
				}
				%>
			</p>
			<p class="center">
				<strong>Percentage:</strong> ${percentage}
			</p>
			<div class="delete-button-container">
				<a href="deleteStudent?studentID=${student.studentID}">Delete
					Student</a>
			</div>
		</c:if>
		<c:if test="${not empty errorMessage}">
			<p class="error-message">${errorMessage}</p>
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