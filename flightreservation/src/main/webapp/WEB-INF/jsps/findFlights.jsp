<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1" name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Flight reservation Application</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		
		<link href="https://fonts.googleapis.com/css?family=Abril+Fatface|Acme"
			rel="stylesheet">
			
		
		<script type="text/javascript">
			$(function(){
				$("#from").autocomplete({
					source: "fromautocomplete",
					minLength: 2
				});
			});
			
			$(function(){
				$("#to").autocomplete({
					source: "toautocomplete",
					minLength: 2
				});
			});
		</script>
		
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
						href="/flightreservation/searchFlights">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/flightreservation/logout">Sign Out</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="main">
			<h2 class="text-center">Find Flights</h2>
			<div class="jumbotron">
				<form action="findFlights" method="post">
					<div class="form-group">
						<input type="text" class="form-control input-lg" name="from"
							placeholder="From" required="required" id="from">
					</div>
					<div class="form-group">
						<input type="text" class="form-control input-lg" name="to"
							placeholder="To" required="required" id="to">
					</div>
					<div class="form-group">
						<input type="date" class="form-control input-lg"
							name="departureDate" placeholder="Departure Date"
							required="required">
					</div>
					<div class="form-group clearfix">
						<button type="submit" class="btn btn-block btn-danger btn-lg ">Search</button>
					</div>
				</form>
				<div></div>
			</div>
		</div>
	</div>
	
</body>
</html>