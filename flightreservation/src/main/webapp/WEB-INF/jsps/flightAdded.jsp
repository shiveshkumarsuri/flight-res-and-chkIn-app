<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
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
						href="/flightreservation/addFlight">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/flightreservation/logout">Sign Out</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="main">
			<h2 class="text-center">Flight Added Successfully</h2>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th colspan="2" class="text-center">Flight Details</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Flight Id</td>
						<td>${flight.id}</td>
					</tr>
					<tr>
						<td>Flight Number</td>
						<td>${flight.flightNumber}</td>
					</tr>
					<tr>
						<td>Operating Airlines</td>
						<td>${flight.operatingAirlines}</td>
					</tr>
					<tr>
						<td>Departure City</td>
						<td>${flight.departureCity}</td>
					</tr>
					<tr>
						<td>Arrival City</td>
						<td>${flight.arrivalCity}</td>
					</tr>
					<tr>
						<td>Departure Date</td>
						<td>${flight.dateOfDeparture}</td>
					</tr>
				</tbody>
			</table>
			<P class="col-md-3">
				<a href="/flightreservation/addFlight">Add another flight</a>
			</P>
		</div>
	</div>
</body>
</html>