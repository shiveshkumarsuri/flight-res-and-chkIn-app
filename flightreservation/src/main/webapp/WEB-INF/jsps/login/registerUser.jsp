<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>User Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Acme"
	rel="stylesheet">
</head>
<body>
	<div class="navdiv">
		<nav class="navbar navbar-expand-sm navbar-light bg-faded">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#nav-content" aria-controls="nav-content"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- Brand -->
			<a class="navbar-brand" href="#">IndoAmerican Flight Reservation</a>

			<!-- Links -->
			<div class="collapse navbar-collapse justify-content-end"
				id="nav-content">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/flightreservation">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="main">

			<div class="login-form">
				<h2 class="text-center">User Registration</h2>
				<form action="registerUser" method="post">

					<div class="form-group">
						<input type="text" class="form-control input-lg" name="firstName"
							placeholder="First Name" required="required">
					</div>
					<div class="form-group">
						<input type="text" class="form-control input-lg" name="lastName"
							placeholder="Last Name" required="required">
					</div>
					<div class="form-group">
						<input type="email" class="form-control input-lg" name="email"
							placeholder="Email" required="required">
					</div>
					<div class="form-group">
						<input type="password" class="form-control input-lg"
							name="password" placeholder="Password" required="required">
					</div>
					<div class="form-group">
						<input type="password" class="form-control input-lg"
							name="confirmPassword" placeholder="Confirm Password"
							required="required">
					</div>
					<div class="form-group clearfix">
						<button type="submit" class="btn btn-block btn-primary btn-lg ">Register</button>
					</div>
				</form>
				<div class="hint-text helper">
					Already have an account? <a href="showLogin">Log in</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>