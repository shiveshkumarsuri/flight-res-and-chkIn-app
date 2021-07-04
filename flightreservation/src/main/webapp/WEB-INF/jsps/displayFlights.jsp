<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
						href="/flightreservation">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/flightreservation/logout">Sign Out</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="main">
			<h2 class="text-center">Flights Available</h2>
			<c:choose>
				<c:when test="${not empty flights}">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>Flights</th>
								<th>Departure City</th>
								<th>Arrival City</th>
								<th>Departure Time</th>
								<th>Choose</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${flights}" var="flight">
								<tr>
									<td>${flight.operatingAirlines}</td>
									<td>${flight.departureCity}</td>
									<td>${flight.arrivalCity}</td>
									<td>${flight.estimatedDepartureTime}</td>
									<td><a
										href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="/flightreservation/searchFlights" class="btn btn-info mt-3 p-2">Search Again</a>
				</c:when>
				<c:otherwise>
				<div class="jumbotron">
					<h2>Sorry! No flights found</h2>
					<p><strong>Try Searching for some other date and location</strong></p>
					<a href="/flightreservation/searchFlights" class="btn btn-danger mt-3 p-2">Back</a>
				</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>