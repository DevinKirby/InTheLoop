<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head><link rel="icon" type="image/png" href="pizzaSlice.ico" sizes="16x16"></head>
<title>PizzaMover!</title>
<h1>Welcome to the Grand Circus Pizza Mover!</h1>
<h4>The application for the people mover.</h4>


<c:if test="${message != null}">
    <p><i>${message}</i></p>
</c:if>

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

<form action="DatabaseServlet" method="post">
<p>Sign in to save results</p>
<label>Email:</label>
     <input type="text" name="email" value=""/><br>
    <label>&nbsp;</label>
<label>Name:</label>
     <input type="text" name="name" value=""/><br>
    <label>&nbsp;</label>
    <input type="submit" value="Log in" class="margin_left">
    </form>
<p><c:out value= "${x}"/></p>

