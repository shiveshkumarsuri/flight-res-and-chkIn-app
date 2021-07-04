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
			<a class="navbar-brand" href="#">IndoAmerican Flight Reservation</a>

			<!-- Links -->
			<div class="collapse navbar-collapse justify-content-end"
				id="nav-content">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/flightreservation/findFlights">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/flightreservation/logout">Sign Out</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="main comp">
			<div class="jumbotron">
				<h2 class="text-center">Reservation completed Successfully.</h2>
				<h3>Reservation created successfully and PNR: <span>WDTAM${msg}</span></h3>
				<h3>You will receive a confirmation <span>email</span> and <span>SMS</span> along with your <span>Itinerary attached</span>. </h3>
				<a href="/flightreservation/searchFlights" class="text-center btn btn-info mt-3 p-2">Book another ticket</a>
			</div>
		</div>
	</div>
</body>
</html>