<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
     <%@ page session="false" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details/Add</title>
</head>
<body>
<h3>Selected items:</h3>
<c:forEach items="${list}" var="item">
<form:form method="post" action="/SpringNewProject/app/additem" >
<input type="text" value="${item.pname}" name="addeditem"/> 
<table>
<tr>
<td>ID: <c:out value="${item.pid}"> </c:out></td>
<td>Color: <c:out value="${item.color}"> </c:out></td>
<td>Price: <c:out value="${item.price}"> </c:out></td>
<td>Stock: <c:out value="${item.stock}"> </c:out></td>
<%-- <td> <c:out value="${item.quantity}"> </c:out></td> --%>
<%-- <td> <a href="/SpringNewProject/additem?id=<c:out value="${item.pid}"> </c:out>"> Add to Cart</a></td> --%>
</tr>
</table>
<input type="submit" value="Add to Cart" /> 
</form:form>
<br> <br>
</c:forEach>
<form:form method="post" action="/SpringNewProject/app/viewmycart" >
<input type="submit" value="View Cart" />
</form:form>
<a href="/SpringNewProject/app/Logout">Logout</a> 
</body>
</html>