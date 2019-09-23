<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Choose Plan" />
<c:set var="profileImageUrl" scope="request"
	value="${employee.getProfileImageUrl()}" />
<c:set var="employeeName" scope="request"
	value="${employee.getEmployeeName()}" />
<%@include file="../include/login-header.jsp"%>
<script>
	function convertAmount() {
		var amount = document.getElementById("amount").value;
		document.getElementById("usd").innerHTML = parseFloat(amount) / 70;
		document.getElementById("yen").innerHTML = parseFloat(amount) * 1.50;
	}
</script>
<div align="center">
	<div class="card" style="width: 24rem;">
		<div class="card-header">
			<h3 class="card-title">Choose Plan</h3>
		</div>
		<div class="card-body">
			<c:url value="/login/choosePlan" var="choosePlanUrl" />
			<form:form action="${choosePlanUrl}" modelAttribute="planForm">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="type">Vehicle Type</form:label>
					<form:input path="type" cssClass="form-control" id="type"
						placeholder="Vehicle Type" value="${vehicle.getType()}"
						readonly="true" />
					<form:errors path="type" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="amount">Amount (INR)</form:label>
					<form:select path="amount" id="amount" cssClass="form-control"
						onchange="convertAmount()">
						<form:option path="amount" value="${plan.getDaily()}"
							cssClass="form-control">${plan.getDaily()} INR Daily</form:option>
						<form:option path="amount" value="${plan.getMonthly()}"
							cssClass="form-control">${plan.getMonthly()} INR Monthly</form:option>
						<form:option path="amount" value="${plan.getYearly()}"
							cssClass="form-control">${plan.getYearly()} INR Yearly</form:option>
					</form:select>
				</div>
				<div class="form-group">
					Amount in USD : <span id="usd">${plan.getDaily()/70}</span>
				</div class="form-group">
				<div>
					Amount in YEN : <span id="yen">${plan.getDaily()*1.50}</span>
				</div>
				<button type="submit" class="btn btn-primary">Save Plan</button>
			</form:form>
		</div>
	</div>
</div>