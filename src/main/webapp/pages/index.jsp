<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Report management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container p-2">
		<h2>Insurance Report Generation</h2>
	</div>
	
	<div class="container p-2">
		<form:form modelAttribute="search" action="" method="post" >
			<table>
				<tr>
					<td>Choose a plan:</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${names}" />
						</form:select></td>
					<td>Choose a plan status:</td>
					<td><form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${planStatus}" />
						</form:select></td>
					<td>Choose a gender:</td>
					<td><form:select path="gender">
							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Fe-Male">Fe-male</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td>Choose a plan start date:</td>
					<td><form:input class="datepicker" type="date" data-date-format="mm/dd/yyyy" path="planStartDate" /></td>
					<td>Choose a plan end date:</td>
					<td><form:input class="datepicker" type="date" data-date-format="mm/dd/yyyy" path="planEndDate" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="search" class="btn btn-primary" /></td>
				</tr>

			</table>
		</form:form>
		<hr />
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Citizen Name</th>
					<th scope="col">Citizen Gender</th>
					<th scope="col">Citizen Plan Name</th>
					<th scope="col">Citizen Plan Status</th>
					<th scope="col">Citizen Plan Start Date</th>
					<th scope="col">Citizen Plan End Date</th>
					<th scope="col">Citizen Denial Reason</th>
					<th scope="col">Citizen Terminate Reason</th>
					<th scope="col">Citizen Termination Date</th>
					<th scope="col">Citizen Benefited Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allList}" var="citizen" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${citizen.citizenName}</td>
						<td>${citizen.citizenGender}</td>
						<td>${citizen.citizenPlanName}</td>
						<td>${citizen.citizenPlanStatus}</td>
						<td>${citizen.citizenPlanStartDate}</td>
						<td>${citizen.citizenPlanEndDate}</td>
						<td>${citizen.citizenDenailReason}</td>
						<td>${citizen.citizenTerminateReason}</td>
						<td>${citizen.citizenTerminationDate}</td>
						<td>${citizen.citizenBenfitedAmount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr />
		Export: <a class="p-1 rounded" href="#" style="text-decoration: none">excel</a>
		&nbsp; <a class="p-1 rounded" href="#" style="text-decoration: none">pdf</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
		
	</script>

</body>
</html>
