<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>User Login</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Acme|Ubuntu" rel="stylesheet">
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
					<li class="nav-item"><a class="nav-link" href="/flightreservation">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
    					<li class="nav-item"><a class="nav-link" href="/flightreservation/logout">Sign Out</a></li>
				</ul>
				</div>
		</nav>
		</div>
	<div class="container">
	<div class="main">
	<h2 class="text-center p-5"><span class="text-success">Hello Admin,</span> You May Add Flight</h2>
	
		<form action="addNewFlight" method="post" class="add-flight">
		  <div class="row p-4">
		    <div class="col">
		      <input type="text" class="form-control" placeholder="Operating Airline" name="operatingAirline">
		    </div>
		    <div class="col">
		      <input type="text" class="form-control" placeholder="Flight Number" name="flightNumber">
		    </div>
		  </div>
		
		  <div class="row p-4">
		    
		    <div class="col">
		      <input type="text" class="form-control" placeholder="Departure City" name="departureCity">
		    </div>
		    <div class="col">
		      <input type="text" class="form-control" placeholder="Arrival City" name="arrivalCity">
		    </div>
		  </div>
		   <div class="row p-4">
		    <div class="col">
		      <input type="date" class="form-control" placeholder="Departure Date" name="departureDate">
		    </div>
		    <div class="col">
		      <input type="datetime-local" class="form-control" placeholder="Estimated Departure Time" name="estimatedDepartureTime">
		    </div>
		  </div>
		  <div class="form-group clearfix p-4">
	            <button type="submit" class="btn btn-block btn-danger ">Add Flight</button>
	       </div>
		</form>
		</div>
	</div>
</body>
</html>