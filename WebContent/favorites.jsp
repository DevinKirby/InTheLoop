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
<title>Your Favorites</title>
</head>

<body>
<div id="map">
    <script type="text/javascript">
    var map = L.map('map').setView([42.3311, -83.0464], 15);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
        maxZoom: 18,
        id: 'peoplemover.741040bc',
        accessToken: 'pk.eyJ1IjoicGVvcGxlbW92ZXIiLCJhIjoiMGNiYzRjMGI2ZTgzNTNmZTE2ZDFmYmFlNjc2M2U1MGQifQ.53BJ0DQcyQiNeGh2jf-_pA'
    }).addTo(map);
    
//     var marker = L.marker([<c:out value="${stationCoords}" />]).addTo(map);
//     marker.bindPopup("<b>Hello, Java!</b><br>This is <c:out value="${stationName}" /> Station.").openPopup();
    
    <c:forEach items="${location}" var="location">
    var marker = L.marker([<c:out value="${location.lat}" />, <c:out value="${location.lng}" />]).addTo(map);
    marker.bindPopup("<b><c:out value="${location.name}"/></b><br><c:out value="${location.address}"/> ");
	</c:forEach>    
    </script>
  </div>
  
  <div class="locations">  
    <h2>Favorites:</h2>
    <c:forEach items="${location}" var="location">
           <p><b><c:out value="${location.name}" /></b><br>
           <c:out value="${location.address}" /><br>
           </p>
           </c:forEach>
   </div>
   
</body>
</html>