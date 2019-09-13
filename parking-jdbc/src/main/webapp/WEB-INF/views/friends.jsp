<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Friend List" />
<c:set var="profileImageUrl" scope="request"
	value="${employee.getProfileImageUrl()}" />
<c:set var="employeeName" scope="request"
	value="${employee.getFullName()}" />
<%@include file="../include/login-header.jsp"%>
	<div align="center">
		<div class="card">
			<div class="card-header">
				<h3 class="card-title">Friend List</h3>
			</div>
			<div class="card-body">
				<table class="table">
					<thead class="thead-dark">
						<th>Image</th>
						<th>Name</th>
						<th>Contact No</th>
						<th>Email</th>
					</thead>
					<tbody class="tbody-striped ">
						<c:forEach items="${friendList}" var="friend">
							<tr>
							<td><img src="${friend.getImageUrl()}" class="rounded-circle" height="50"> </td>
							<td>${friend.getFullName()}</td>
							<td>${friend.getContactNo()}</td>
							<td>${friend.getEmailId()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>