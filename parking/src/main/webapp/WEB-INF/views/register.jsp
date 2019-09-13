<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Register" />
<%@include file="../include/header.jsp"%>
<div align="center">
	<div class="card" style="width: 24rem;">
		<div class="card-header">
			<h3 class="card-title">Register||Employee</h3>
		</div>
		<div class="card-body">
			<c:url value="/register" var="registerActionUrl" />
			<form:form action="${registerActionUrl}"
				modelAttribute="registerEmployee">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="fullName">Full Name</form:label>
					<form:input path="fullName" cssClass="form-control" id="fullName"
						placeholder="full Name" />
					<form:errors path="fullName" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="gender">Gender</form:label>
					<span class="form-control"> <form:radiobutton path="gender"
							value="male" /> Male <form:radiobutton path="gender"
							value="female" /> Female 
					</span>
					<form:errors path="gender" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="employeeId">Employee ID</form:label>
					<form:input path="employeeId" cssClass="form-control" id="employeeId"
						placeholder="Employee Id" />
					<form:errors path="employeeId" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="emailId">Email Id</form:label>
					<form:input path="emailId" cssClass="form-control" id="emailId"
						placeholder="Email Id" />
					<form:errors path="emailId" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:password path="password" cssClass="form-control"
						id="password" placeholder="Password" />
					<form:errors path="password" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="confirmPassword">Confirm Password</form:label>
					<form:password path="confirmPassword" cssClass="form-control"
						id="confirmPassword" placeholder="Confirm Password" />
					<form:errors path="confirmPassword" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="contactNo">Contact No</form:label>
					<form:input path="contactNo" cssClass="form-control"
						id="contactNo" placeholder="Contact No" />
					<form:errors path="contactNo" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="oragnization">Oragnization</form:label>
					<form:select path="oragnization" cssClass="form-control">
						<form:option path="oragnization" value="metacube"
							cssClass="form-control">metacube</form:option>
						<form:option path="oragnization" value="metaconnect"
							cssClass="form-control">metaconnect</form:option>
						<form:option path="oragnization" value="metacafe"
							cssClass="form-control">metacafe</form:option>
						<form:option path="oragnization" value="metamoney"
							cssClass="form-control">metamoney</form:option>
					</form:select>
				</div>
				<button type="submit" class="btn btn-primary">Register</button>
			</form:form>
			<a href="/login">Already Have Account Click Here</a>
		</div>
	</div>
</div>