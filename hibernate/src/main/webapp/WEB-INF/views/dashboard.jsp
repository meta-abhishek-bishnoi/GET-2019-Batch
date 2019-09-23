<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Dashboard" />
<c:set var="profileImageUrl" scope="request"
	value="${employee.getProfileImageUrl()}" />
<c:set var="employeeName" scope="request"
	value="${employee.getFullName()}" />
<%@include file="../include/login-header.jsp"%>
<div align="center">
	<div class="card" style="width: 30rem;">
		<div class="card-header">
			<h3 class="card-title">Profile</h3>
		</div>
		<div class="card-body">
		<table class="table">
			<tbody class="tbody-striped ">
				<tr>
				<td><a href="/login/editProfile" class="btn btn-primary">Edit Profile</a></td>
				<td><a href="/login/friends" class="btn btn-primary">friends</a></td>
				</tr>
				<tr>
				<td>Employee Name</td>
				<td>${employee.getFullName()}</td>
				</tr>
				<tr>
				<td>Employee ID</td>
				<td>${employee.getEmployeeId()}</td>
				</tr>
				<tr>
				<td>Gender</td>
				<td>${employee.getGender()}</td>
				</tr>
				<tr>
				<td>Contact No</td>
				<td>${employee.getContactNo()}</td>
				</tr>
				<tr>
				<td>Email ID</td>
				<td>${employee.getEmailId()}</td>
				</tr>
				<tr>
				<td>Organisation</td>
				<td>${employee.getOrganisation()}</td>
				</tr>
				<tr>
				<td>Vehicle Name</td>
				<td>${vehicle.getVehicleName()}</td>
				</tr>
				<tr>
				<td>Vehicle Type</td>
				<td>${vehicle.getVehicleType()}</td>
				</tr>
				<tr>
				<td>Vehicle Number</td>
				<td>${vehicle.getVehicleNumber()}</td>
				</tr>
				<tr>
				<td>Plan Amount</td>
				<td>${vehicle.getAmount()} USD Only</td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
</div>
