<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Add Vehicle" />
<c:set var="profileImageUrl" scope="request"
	value="${employee.getProfileImageUrl()}" />
<c:set var="employeeName" scope="request"
	value="${employee.getEmployeeName()}" />
<%@include file="../include/login-header.jsp"%>

<div align="center">
	<div class="card" style="width: 24rem;">
		<div class="card-header">
			<h3 class="card-title">Add Vehicle</h3>
		</div>
		<div class="card-body">
			<c:url value="/login/addVehicle" var="addVehicleUrl" />
			<form:form action="${addVehicleUrl}"
				modelAttribute="vehicleForm">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="name">Vehicle Name</form:label>
					<form:input path="name" cssClass="form-control" id="name"
						placeholder="Vehicle Name" />
					<form:errors path="name" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="type">Type</form:label>
					<form:select path="type" cssClass="form-control">
						<form:option path="type" value="byCycle"
							cssClass="form-control">By Cycle</form:option>
						<form:option path="type" value="motorCycle"
							cssClass="form-control">Motor Cycle</form:option>
						<form:option path="type" value="fourWheeler"
							cssClass="form-control">Four Wheeler</form:option>
					</form:select>
				</div>
				<div class="form-group">
					<form:label path="number">Vehicle Number</form:label>
					<form:input path="number" cssClass="form-control" id="number"
						placeholder="Vehicle Number" />
					<form:errors path="number" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="employeeId">Employee Id</form:label>
					<form:input path="employeeId" cssClass="form-control" id="employeeId"
						placeholder="Employee Id" value="${employee.getEmployeeId()}" readonly="true"/>
					<form:errors path="employeeId" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="identification">Identification</form:label>
					<form:input path="identification" cssClass="form-control" id="identification"
						placeholder="Identification"/>
					<form:errors path="employeeId" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Add Vehicle</button>
			</form:form>
		</div>
	</div>
</div>