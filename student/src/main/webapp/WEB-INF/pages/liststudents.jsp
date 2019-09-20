<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Students</title>
</head>
<body>
	<pre:if test="${not empty listStudents}">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Father Name</th>
					<th scope="col">Email</th>
					<th scope="col">Class</th>
					<th scope="col">Age</th>
				</tr>
			</thead>
			<tbody class="tbody-striped ">
				<pre:forEach items="${listStudents}" var="student">
					<tr>
						<th scope="row">${student.getId()}</th>
						<td>${student.getFirstName()}</td>
						<td>${student.getLastName()}</td>
						<td>${student.getFatherName()}</td>
						<td>${student.getEmail()}</td>
						<td>${student.getStudentClass()}</td>
						<td>${student.getAge()}</td>
					</tr>
				</pre:forEach>
			</tbody>
		</table>
	</pre:if>
	<div align="center">
	<a href="/">Home</a>
	</div>
</body>
</html>