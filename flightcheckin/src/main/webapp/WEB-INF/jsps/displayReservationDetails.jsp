<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Flight Reservation Application</title>
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
					<li class="nav-item"><a class="nav-link"
						href="/flightcheckin">Home</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="container">

	<div class="main">
	<h2 class="text-center mt-4">Reservation Details</h2>
	
		<c:choose>
		<c:when test="${not empty reservation}">
					<div class="row">
						<div class="col-md-6">
							<fieldset class="border p-2">
								<legend class="w-auto">Flight Details</legend>
								<dl class="row">
									<dt class="col-sm-6">Airline: </dt>
									<dd class="col-sm-6">${reservation.flight.operatingAirlines}</dd> 
									<dt class="col-sm-6">Flight Number:</dt>
									<dd class="col-sm-6">${reservation.flight.flightNumber}</dd>
									<dt class="col-sm-6">Departure City:</dt> 
									<dd class="col-sm-6">${reservation.flight.departureCity}</dd>
									<dt class="col-sm-6">Arrival City: </dt>
									<dd class="col-sm-6">${reservation.flight.arrivalCity}</dd>
									<dt class="col-sm-6">Date Of Departure:</dt>
									<dd class="col-sm-6">${reservation.flight.dateOfDeparture}</dd> 
									<dt class="col-sm-6">Estimated Departure Time:</dt>
									<dd class="col-sm-6"	>${reservation.flight.estimatedDepartureTime}</dd>
								</dl>
							</fieldset>
						</div>
						<div class="col-md-6">
							<fieldset class="border p-2">
								<legend class="w-auto">Passenger Details</legend>
								<dl class="row">
									<dt class="col-sm-4">First Name:</dt> 
									<dd class="col-sm-8">${reservation.passenger.firstName}</dd> 
									<dt class="col-sm-4">Last Name:</dt> 
									<dd class="col-sm-8">${reservation.passenger.lastName}</dd>
									<dt class="col-sm-4">Email: </dt>
									<dd class="col-sm-8">${reservation.passenger.email}</dd> 
									<dt class="col-sm-4">Phone:</dt>
									<dd class="col-sm-8">${reservation.passenger.phone}</dd>
								</dl>
								<form action="completeCheckIn" method="post">
									<span class="text-danger">Enter the number of Bags: </span>
									<select name="numberOfBags">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</select>
									<input type="hidden" value="${reservation.id}" name="reservationId"/> 
									<br/>
									<input type="submit" class="btn btn-success chk" value="Check In"/>
								</form>
								
							</fieldset>
						</div>
					</div>
		</c:when>
			<c:otherwise>
				<p>${msg}</p>
			    	
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>