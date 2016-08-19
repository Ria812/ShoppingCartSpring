<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ page session="false" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${msg}</h3>
<h3>${msg1}</h3>
<form:form method="post" commandName="selecteditems" >
<c:forEach items="${myList1}" var="it">
<form:checkbox path="userList" value="${it.pname}" />
${it.pname}
<br>  
</c:forEach>
<br>	
<td><input type="submit" value="Submit" /></td>
</form:form>
<a href="/SpringNewProject/app/Logout">Logout</a> 
</body>
</html>