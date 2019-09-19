<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <title>Add Student</title>
  </head>
  <body>
  	<div class="container">
  		<form:form modelAttribute="student">
  			<form:errors cssClass="text-danger"/>
  			<div class="form-group">
  			<form:label path="firstName">First Name</form:label>
  			<form:input path="firstName" cssClass="form-control" id="firstName" placeholder="Student First Name"/>
  			<form:errors path="firstName" cssClass="text-danger"/>
  			</div>
  			<div class="form-group">
  			<form:label path="lastName">Last Name</form:label>
  			<form:input path="lastName" cssClass="form-control" id="firstName" placeholder="Student Last Name"/>
  			<form:errors path="lastName" cssClass="text-danger"/>
  			</div>
  			<div class="form-group">
  			<form:label path="fatherName">Father Name</form:label>
  			<form:input path="fatherName" cssClass="form-control" id="firstName" placeholder="Student Father Name"/>
  			<form:errors path="fatherName" cssClass="text-danger"/>
  			</div>
  			<div class="form-group">
  			<form:label path="email">Email</form:label>
  			<form:input path="email" cssClass="form-control" id="firstName" placeholder="Student Eamil Id"/>
  			<form:errors path="email" cssClass="text-danger"/>
  			</div>
  			<div class="form-group">
  			<form:label path="studentClass">Class</form:label>
  			<form:input path="studentClass" cssClass="form-control" id="firstName" placeholder="Class"/>
  			<form:errors path="studentClass" cssClass="text-danger"/>
  			</div>
  			<div class="form-group">
  			<form:label path="age">Age</form:label>
  			<form:input path="age" cssClass="form-control" id="firstName" placeholder="Age"/>
  			<form:errors path="age" cssClass="text-danger"/>
  			</div>
  			<button type="submit" class="btn btn-primary">Add Student</button>
  		</form:form>
  	</div>
  	<div align="center">
  	<a href="/">Home</a>
  	</div>
  </body>
  </html>