<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="pizzaSlice.ico" sizes="16x16">
<link rel="stylesheet" type="text/css" href="Styles/resultsStyles.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css" />
<link rel="stylesheet" type="text/css" href="Styles/jquery.dataTables.css">
<script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
<script src="Leaflet.MakiMarkers.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="jquery.dataTables.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="51763597782-00lt8ge8mum41c9li0cq8aurpgk6rftl.apps.googleusercontent.com">
<title>In The Loop Favorites</title>
</head>

<body>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">In The Loop</a>
		</div>

		<div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>

			</ul>
		</div>
	</div>
	</nav>

	<div id="map">
		<script type="text/javascript">
			var map = L.map('map').setView([ 42.3311, -83.0464 ], 15);
			L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}',
							{	attribution : 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
								maxZoom : 18,
								id : 'peoplemover.741040bc',
								accessToken : 'pk.eyJ1IjoicGVvcGxlbW92ZXIiLCJhIjoiMGNiYzRjMGI2ZTgzNTNmZTE2ZDFmYmFlNjc2M2U1MGQifQ.53BJ0DQcyQiNeGh2jf-_pA'
							}).addTo(map);

			//     var marker = L.marker([<c:out value="${stationCoords}" />]).addTo(map);
			//     marker.bindPopup("<b>Hello, Java!</b><br>This is <c:out value="${stationName}" /> Station.").openPopup();

			<c:forEach items="${location}" var="location" varStatus="status">
			var numberIcon = L.MakiMarkers.icon({icon: "${status.count}", color: "#0a0", size: "l"});
			var marker = L.marker(
					[ <c:out value="${location.lat}" />, <c:out value="${location.lng}" /> ], {icon: numberIcon}).addTo(map);
			marker.bindPopup("<b><c:out value="${location.name}"/></b><br><c:out value="${location.address}"/> ");
			</c:forEach>
		</script>
	</div>
	
	<script>
		$(document).ready(function() {
			$('#tablescroll').dataTable({
				"scrollY" : "250px",
				"scrollCollapse" : true,
				"paging" : false,
				"info" : false,
				"bFilter" : false,
				"bInfo" : false
			});
		});
	</script>

	<div class="container">
		<div class="row">
				<div class="col-md-7">
					<table class="table" id="tablescroll">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Address</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${location}" var="location" varStatus="status">
								<tr>
									<td>${status.count}.</td>
									<td><c:out value="${location.name}" /></td>
									<td><c:out value="${location.address}" /></td>
								</tr>
						</tbody>
						</c:forEach>
					</table>
				</div>
			

			<div class="col-md-5" id="searchcol">


				<form action="PizzaServlet"  method="post">
					<div class="form-group">
						<label class="pad_top">Station:</label> <select name="stationID"
							class="form-control" value="Grand Circus Park">
							<option value="Times Square">Times Square</option>
							<option value="Grand Circus Park">Grand Circus Park</option>
							<option value="Broadway">Broadway</option>
							<option value="Cadillac Center">Cadillac Center</option>
							<option value="Greektown">Greektown</option>
							<option value="Bricktown">Bricktown</option>
							<option value="Renaissance Center">Renaissance Center</option>
							<option value="Millender Center">Millender Center</option>
							<option value="Financial District">Financial District</option>
							<option value="Joe Louis Arena">Joe Louis Arena</option>
							<option value="Cobo Center">Cobo Center</option>
							<option value="Fort Cass">Fort/Cass</option>
							<option value="Michigan Ave.">Michigan Ave.</option>
						</select>
					</div>
					<div class="form-group">
						<label>Keyword:</label> <input type="text" name="keyword" class="form-control" value=""/>
					</div>
					<div class="form-group">
					<input type="hidden" id="hiddenfield"/>
						<button type="submit" class="btn btn-primary">Get in the
								Loop</button>
					</div>
				</form>
				<p>Sign in securely with google to save favorite places!</p>
				<div class="g-signin2" data-onsuccess="onSignIn">
					<script>
						function onSignIn(googleUser) {
							//var auth2 = gapi.auth2.getAuthInstance();
							//auth2.onSignIn(googleUser).then(function(){
							var profile = googleUser.getBasicProfile();
							console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
							console.log('Name: ' + profile.getName());
							console.log('Image URL: ' + profile.getImageUrl());
							console.log('Email: ' + profile.getEmail());
							document.getElementById("hiddenfield").value=profile.getEmail();

						};
					</script>
				</div>
				<a href="#" onclick="signOut();">Sign out</a>
				<script>
					function signOut() {
						var auth2 = gapi.auth2.getAuthInstance();
						auth2.signOut().then(function() {
							console.log('User signed out.');
							window.location.assign("index.jsp");
						});
					}
				</script>
			</div>
		</div>
	</div>

</body>
</html>