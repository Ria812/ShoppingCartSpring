<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page session="false" %>  
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body>
<h2>List of items:</h2>
<c:forEach items="${orderlist}" var="item">
<table>
<tr>
<td>Name: <c:out value="${item.pname}"> </c:out></td>
<td>ID: <c:out value="${item.pid}"> </c:out></td>
<td>Color: <c:out value="${item.color}"> </c:out></td>
<td>Price: <c:out value="${item.price}"> </c:out></td>
</tr>
</table>
<br>
</c:forEach>
Total cart price:<br>${totalprice}
<br>
<a href="/SpringNewProject/app/Logout">Logout</a> 
</body>
</html>