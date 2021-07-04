<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Flight reservation Application</title>
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
			<a class="navbar-brand" href="#">IndoAmerican Flight Check In</a>

			<!-- Links -->
			<div class="collapse navbar-collapse justify-content-end"
				id="nav-content">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/flightcheckin">Home</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">

			<div class="main">
				<div class="jumbotron d-block text-center mt-5">
					<h2>Check-in completed Successfully.</h2>
					<p><a href="/flightcheckin">Do Another Check In</a></p>
				</div>
			</div>
	</div>
</body>
</html>