<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/png" href="pizzaSlice.ico" sizes="16x16">
  <link rel="stylesheet" type="text/css" href="Styles/resultsStyles.css">
  <link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css" />
  <script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>

<title>Your adventure awaits!</title>
</head>
<body>
  <div id="map">
    <script type="text/javascript">
    var map = L.map('map').setView([<c:out value="${stationCoords}" />], 16);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
        maxZoom: 18,
        id: 'peoplemover.741040bc',
        accessToken: 'pk.eyJ1IjoicGVvcGxlbW92ZXIiLCJhIjoiMGNiYzRjMGI2ZTgzNTNmZTE2ZDFmYmFlNjc2M2U1MGQifQ.53BJ0DQcyQiNeGh2jf-_pA'
    }).addTo(map);
    
    var marker = L.marker([<c:out value="${stationCoords}" />]).addTo(map);
    marker.bindPopup("<b>Hello, Java!</b><br>This is <c:out value="${stationName}" /> Station.").openPopup();
    
    <c:forEach items="${location}" var="location">
    var marker = L.marker([<c:out value="${location.lat}" />, <c:out value="${location.lng}" />]).addTo(map);
    marker.bindPopup("<b><c:out value="${location.name}"/></b><br><c:out value="${location.address}"/> ");
	</c:forEach>    
    </script>
  </div>
  
  
  
  <div class="locations">  
    
    <c:forEach items="${location}" var="location">
           <b><c:out value="${location.name}" /></b><br>
           <c:out value="${location.address}" />
           
           <input type="button" id="<c:out value="${location.id}" />" value="Add to Favorites">
           <div id="responsediv"></div>
           
           <script>
			 	$(document).ready(function() {  
			 		$('#<c:out value="${location.id}" />').click(function(event) {    
                  var locname='<c:out value="${location.name}"/>';
   		          var locaddress='<c:out value="${location.address}"/>';   
   		          var locLat ='<c:out value="${location.lat}"/>';
   		          var locLong='<c:out value="${location.lng}"/>';
   		          var locID='<c:out value="${location.id}"/>';
                  $.post('FavoritesServlet',{name:locname, 
                 	 						 address:locaddress, lat:locLat, lng:locLong, id:locID},function(responseText) {  
                         $('#responsediv').text(responseText); 
                     }); 
                 }); 
            }); 
	</script>
	</c:forEach>
    
  </div>
  
  <form action="PizzaServlet" method="post">
    <label class="pad_top">Station:</label>
    <select name="stationID" value="Grand Circus Park">
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
    </select><br>
    <label>Keyword:</label>
    <input type="text" name="keyword" value="" autofocus/><br>
    <label>&nbsp;</label>
    <input type="submit" value="Let's find some fun!" class="margin_left">
</form>
  

</body>
</html>
