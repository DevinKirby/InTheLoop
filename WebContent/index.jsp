<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><link rel="icon" type="image/png" href="pizzaSlice.ico" sizes="16x16">
 <link rel="stylesheet" type="text/css" href="Styles/bootstrap.css">
<link rel="stylesheet" type="text/css" href="Styles/main.css">
<title>In The Loop</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="51763597782-00lt8ge8mum41c9li0cq8aurpgk6rftl.apps.googleusercontent.com">

</head>
<!-- <title>PizzaMover!</title> -->
<!-- <h1>Welcome to the Grand Circus Pizza Mover!</h1> -->
<!-- <h4>The application for the people mover.</h4> -->
<body>
<div class="row">
    	<div class="col-md-6">
    		
    	</div>
    </div>
    
  <!-- <div class="dropdown">
      <a class="dropdown-toggle" id="dropdownMenu1" href="#">Dropdown trigger</a>
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
        <li role="presentation" class="divider"></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
      </ul>
    </div>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.js"></script>
    <script>
      $(document).ready(function() {
          $("a.dropdown-toggle").click(function(ev) {
              $("a.dropdown-toggle").dropdown("toggle");
              return false;
          });
          $("ul.dropdown-menu a").click(function(ev) {
              $("a.dropdown-toggle").dropdown("toggle");
              return false;
          });
      });
    </script> -->


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">In The Loop</a>
    </div>
   
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
       
      </ul>
    </div>
  </div>
</nav>



<c:if test="${message != null}">
    <p><i>${message}</i></p>
</c:if>

<!-- <form action="PizzaServlet" method="post"> -->
<!--     <label class="pad_top">Station:</label> -->
<!--     <select name="stationID" value="Grand Circus Park"> -->
<!--     	<option value="Times Square">Times Square</option> -->
<!--     	<option value="Grand Circus Park">Grand Circus Park</option> -->
<!--     	<option value="Broadway">Broadway</option> -->
<!--     	<option value="Cadillac Center">Cadillac Center</option> -->
<!--     	<option value="Greektown">Greektown</option> -->
<!--     	<option value="Bricktown">Bricktown</option> -->
<!--     	<option value="Renaissance Center">Renaissance Center</option> -->
<!--     	<option value="Millender Center">Millender Center</option> -->
<!--     	<option value="Financial District">Financial District</option> -->
<!--     	<option value="Joe Louis Arena">Joe Louis Arena</option> -->
<!--     	<option value="Cobo Center">Cobo Center</option> -->
<!--     	<option value="Fort Cass">Fort/Cass</option> -->
<!--     	<option value="Michigan Ave.">Michigan Ave.</option> -->
<!--     </select><br> -->
<!--     <label>Keyword:</label> -->
<!--     <input type="text" name="keyword" value="" autofocus/><br> -->
<!--     <label>&nbsp;</label> -->
<!--     <input type="hidden" id="hiddenfield" name="gmail"/> -->
<!--     <input type="submit" value="Let's find some fun!" class="margin_left"> -->
<!-- </form> -->

<!-- <form action="PizzaServlet" method="post"> -->
<!-- <script> -->
<!-- // function $('.dropdown-toggle').dropdown() -->
<!-- </script> -->

<div class="col-md-5" id="searchcol">
	    <form action="FavoritesServlet" method="get">
  	<input type="hidden" value="<c:out value="${gmail}"/>" name="gmail"/>
  	<button type="submit" class="btn btn-info btn-med btn-block">View Favorites</button>
  </form><br>

  <form action="PizzaServlet" class="form-horizontal" method="post">
  <div class="form-group">
    <label class="pad_top">Station:</label>
    <select name="stationID" class="form-control" value="Grand Circus Park">
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
    <label>Keyword:</label>
    <input type="text" name="keyword" class="form-control" value="" /><br>
    </div>
    <input type="hidden" id="hiddenfield" name="gmail"/>
    <div class="form-group">
    <input type="submit" value="Let's find some fun!" class="margin_left">
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
	  document.getElementById("hiddenfield").value=profile.getEmail();
	  console.log('Signed in as ' + profile.getName());
	  //location.reload(true); 
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
      location.reload(true); 
    });
  }
  
</div>
</div>
</script>
<</body>
</html>