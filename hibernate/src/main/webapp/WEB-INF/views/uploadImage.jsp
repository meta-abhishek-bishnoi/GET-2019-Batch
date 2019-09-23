<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Upload Image" />
<c:set var="profileImageUrl" scope="request"
	value="${employee.getProfileImageUrl()}" />
<c:set var="employeeName" scope="request"
	value="${employee.getFullName()}" />
<%@include file="../include/login-header.jsp"%>
<form name="uploadingForm" enctype="multipart/form-data" action="/login/uploadImage"
	method="POST">
	<p>
		<input id="fileInput" type="file" name="uploadingFiles">
	</p>
	<p>
		<input type="submit" value="Upload files">
	</p>
</form>