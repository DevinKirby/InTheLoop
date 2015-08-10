<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link rel="icon" type="image/png" href="pizzaSlice.ico" sizes="16x16">
<link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/main.css">
<title>In The Loop</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="51763597782-00lt8ge8mum41c9li0cq8aurpgk6rftl.apps.googleusercontent.com">

</head>
<!-- <title>PizzaMover!</title> -->
<!-- <h1>Welcome to the Grand Circus Pizza Mover!</h1> -->
<!-- <h4>The application for the people mover.</h4> -->
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



	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4 panel panel-default panel-transparent">
			<div class="col-md-12 panel-body" id="searchcol">



				<form action="PizzaServlet" method="post">
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
						<label>Keyword:</label> <input type="text" name="keyword"
							class="form-control" value="" />
					</div>
					
						<input type="hidden" id="hiddenfield" name="gmail" />
						<div class="form-group">
							<button type="submit" class="btn btn-primary">Get in the
								Loop</button>
						</div>
				</form>
				<form action="FavoritesServlet" method="get">
					<div class="form-group">
						<input type="hidden" id="hiddenfield" name="gmail" />
						<button type="submit" class="btn btn-info  ">View
							Favorites</button>
					</div>
				</form>
			



			<p>Sign in securely with google to save favorite places!</p>
			<div class="g-signin2" data-onsuccess="onSignIn">
				<script>
					function onSignIn(googleUser) {
						var profile = googleUser.getBasicProfile();
						console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
						console.log('Name: ' + profile.getName());
						console.log('Image URL: ' + profile.getImageUrl());
						console.log('Email: ' + profile.getEmail());
						document.getElementById("hiddenfield").value = profile
								.getEmail();
						console.log('Signed in as ' + profile.getName());
						//location.reload(true); 
					}
				</script>
			</div>

			<a href="#" onclick="signOut();">Sign out</a>
			<script>
				function signOut() {
					var auth2 = gapi.auth2.getAuthInstance();
					auth2.signOut().then(function() {
						console.log('User signed out.');
						location.reload(true);
					});
				}
			</script>
		</div>
	</div>
	</div>
</body>
</html>