<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>${pageTitle}</title>
</head>
<body>
	<spring:url value="/login/sucess" var="urlHome" />
	<spring:url value="/logout" var="urlLogout" />
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark  ">
		<a class="navbar-brand" href="#">Metacube Parking</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbarNavDropdown" class="navbar-collapse collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${urlHome}">Home</a></li>
			</ul>
		
            	<ul class="navbar-nav">
                <li class="nav-item">
                	<span style="color:white">Welcome</span> 
                	<a href="/login/uploadImage"><img src="${profileImageUrl}" height="36" ></a>
                	<span style="color:white">${employeeName}</span>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a  style="color:white" class="nav-link" href="${urlLogout}">Logout </a>
                </li>
            </ul>

		</div>
	</nav>