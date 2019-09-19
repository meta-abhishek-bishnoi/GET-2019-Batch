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
<title>Index</title>
</head>
<body>
	<div align="center">${message}</div>
	<pre:if test="${not empty success}">
		<div class="alert alert-success alert-dismissible" role="alert"
			align="center">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">x</span>
			</button>
			<strong>${success}</strong>
		</div>
	</pre:if>
	<div align="center"><a href="/addStudent">Add Student</a></div>
	<div align="center"><a href="/getStudents">View Students</a></div>
</body>
</html>