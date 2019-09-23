<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Login" />
<%@include file="../include/header.jsp"%>
<div align="center">
	<div class="card" style="width: 24rem;">
		<c:if test="${not empty success}">
			<div class="alert alert-success alert-dismissible" role="alert"
				align="center">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">x</span>
				</button>
				<strong>${success}</strong>
			</div>
		</c:if>
		<div class="card-header">
			<h3 class="card-title">Login</h3>
		</div>
		<div class="card-body">
			<c:url value="/login" var="loginActionUrl" />
			<form:form modelAttribute="employeeLogin" action="${loginActionUrl}">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="username">Username</form:label>
					<form:input path="username" cssClass="form-control" id="username"
						placeholder="Username" />
					<form:errors path="username" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:password path="password" cssClass="form-control"
						id="password" placeholder="password" />
					<form:errors path="password" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">login</button>
			</form:form>
		<a href="/register">Don't Have Account Click Here</a>
		</div>
	</div>
</div>