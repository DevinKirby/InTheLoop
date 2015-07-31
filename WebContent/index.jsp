<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>PizzaMover!</title>
<h1>Welcome<c:out value= "${name}"/> to the Grand Circus Pizza Mover!</h1>
<h4>The application for the people mover.</h4>


<c:if test="${message != null}">
    <p><i>${message}</i></p>
</c:if>

<form action="PizzaServlet" method="post">
    <label class="pad_top">Station:</label>
    <select name="stationID" value="Grand Circus Park">
    	<option value="1">Times Square</option>
    	<option value="2">Grand Circus Park</option>
    	<option value="3">Broadway</option>
    	<option value="4">Cadillac Center</option>
    	<option value="5">Greektown</option>
    	<option value="6">Bricktown</option>
    	<option value="7">Renaissance Center</option>
    	<option value="8">Millender Center</option>
    	<option value="9">Financial District</option>
    	<option value="10">Joe Louis Arena</option>
    	<option value="11">Cobo Center</option>
    	<option value="12">Fort/Cass</option>
    	<option value="13">Michigan Ave.</option>
    </select><br>
    <label>Keyword:</label>
    <input type="text" name="keyword" value=""/><br>
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

    
    
    
    

