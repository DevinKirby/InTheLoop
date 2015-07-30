<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your adventure awaits!</title>
</head>
<body>
<c:forEach items="${location}" var="location">
       <p><c:out value="${location.name}" /></p>
       <p><c:out value="${location.address}" /></p>
</c:forEach>
</body>
</html>