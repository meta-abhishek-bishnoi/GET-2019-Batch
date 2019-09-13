<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Edit Profile" />
<c:set var="profileImageUrl" scope="request"
	value="${employee.getProfileImageUrl()}" />
<c:set var="employeeName" scope="request"
	value="${employee.getEmployeeName()}" />
<%@include file="../include/login-header.jsp"%>

<div align="center">
	<div class="card" style="width: 24rem;">
		<div class="card-header">
			<h3 class="card-title">Edit Profile</h3>
		</div>
		<div class="card-body">
			<c:url value="/login/editProfile" var="editActionUrl" />
			<form:form action="${editActionUrl}"
				modelAttribute="editEmployee">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="fullName">Full Name</form:label>
					<form:input path="fullName" cssClass="form-control" id="fullName"
						placeholder="full Name" value="${employee.getEmployeeName()}" />
					<form:errors path="fullName" cssClass="text-danger" />
				</div>
				
				<div class="form-group">
					<form:label path="contactNo">Contact No</form:label>
					<form:input path="contactNo" cssClass="form-control"
						id="contactNo" placeholder="Contact No" value="${employee.getEmployeeContactNo()}"/>
					<form:errors path="contactNo" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Save Changes</button>
			</form:form>
		</div>
	</div>
</div>