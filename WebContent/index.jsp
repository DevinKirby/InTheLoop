<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><link rel="icon" type="image/png" href="pizzaSlice.ico" sizes="16x16">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="51763597782-00lt8ge8mum41c9li0cq8aurpgk6rftl.apps.googleusercontent.com">
</head>
<title>PizzaMover!</title>
<h1>Welcome to the Grand Circus Pizza Mover!</h1>
<h4>The application for the people mover.</h4>


<c:if test="${message != null}">
    <p><i>${message}</i></p>
</c:if>

<form action="PizzaServlet" method="post">
    <label class="pad_top">Station:</label>
    <select name="stationID">
    	<option value="Times Square">Times Square</option>
    	<option value selected="Grand Circus Park">Grand Circus Park</option>
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
    </select><br>
    <label>Keyword:</label>
    <input type="text" name="keyword" value="" autofocus/><br>
    <label>&nbsp;</label>
    <input type="submit" value="Let's find some fun!" class="margin_left">
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
	  console.log('Signed in as ' + profile.getName());
	}
</script>	
</div>
<p>Welcome back! You are logged in as ${profile.getName() }. Please click 'Sign out' if this is not you!</p>
<a href="#" onclick="signOut();">Sign out</a>
<script>
  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
  }
</script>
</body>
</html>


