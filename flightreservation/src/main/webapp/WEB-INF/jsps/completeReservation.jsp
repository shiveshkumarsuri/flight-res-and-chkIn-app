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
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Acme|Ubuntu"
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
		<div class="main">
		
		<h2 class="text-center">Complete Your Reservation</h2>
		<div class="row">
						<div class="col-md-12 f-detail">
							<fieldset class="border p-2">
								<legend class="w-auto">Flight Details</legend>
								<dl class="row">
									<dt class="col-sm-2">Airline : </dt>
									<dd class="col-sm-2">${flight.operatingAirlines}</dd> 
									<dt class="col-sm-2">Departure City:</dt> 
									<dd class="col-sm-2">${flight.departureCity}</dd>
									<dt class="col-sm-2">Arrival City : </dt>
									<dd class="col-sm-2">${flight.arrivalCity}</dd>
								</dl>
						</fieldset>
				</div>
			</div>					
		
			<form action="completeReservation" method="post">
				<div class="row">
					<div class="col-md-6 f-detail">
						<fieldset class="form-group border p-2">
							<legend class="w-auto">Passenger Details</legend>
							<label for="first_name">First Name</label> 
							<input type="text" name="passengerFirstName" class="form-control" required pattern="[a-zA-Z]{2,15}"/> 
							<label for="last_name">Last Name</label>
							<input type="text" name="passengerLastName" class="form-control" required pattern="[a-zA-Z]{2,15}"/> 
							<label for="email">Email </label>
							<input type="email" name="passengerEmail" class="form-control" required/> 
							<label for="phone">Phone </label>
							<input type="text" name="passengerPhone" pattern="[\+]\d{11}"class="form-control" placeholder="+1XXXXXXXXXX" required/>
						</fieldset>
					</div>
					<div class="col-md-6 f-detail">
						<fieldset class="form-group border p-2">
							<legend class="w-auto">Card Details</legend>
							<label for="Card_Name">Name on the card:</label> 
							<input type="text" name="nameOnTheCard" class="form-control" required/> 
							<label for="Card_No">Card Number:</label> 
							<input type="text" name="cardNumber" class="form-control" pattern="\d{16}" placeholder="XXXXXXXXXXXXXXXX" required/>
							<label for="Expiry_Date">Expiry Date :</label> 
							<input type="date" name="expiryDate" class="form-control" required/>
							<label for="CVV">CVV :</label> 
							<input type="text" name="securityCode" class="form-control" pattern="\d{3}" placeholder="XXX" required/>  
							<input type="hidden" name="flightId" value="${flight.id}" required/> 
							<!-- <a href="checkout" class="btn btn-success">Pay</a> -->
							<input type="submit" class="btn btn-info mt-4" name="Confirm"/>
						</fieldset>
					</div>
					
				</div>
			</form>
			<form action="checkout">
			<c:set var="amount" scope="request" value="3000"/>
					<input type="submit" class="btn btn-info mt-4" name="Pay"/>
			</form>
			</div>
		</div>
</body>
</html>