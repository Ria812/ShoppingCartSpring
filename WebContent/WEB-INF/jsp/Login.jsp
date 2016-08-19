<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<center>
		<h2>Login Form</h2>
	</center>
	<form:form method="POST" commandName="user" action="Login">
		<div align="center">
			<table>
				<tr>
					<td>User Name</td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><form:input path="password" /></td>
					<td><form:errors path="password"></form:errors></td>
				</tr>

				<tr>
					<td></td>
					<td><form:button type="submit">Login</form:button></td>

				</tr>
			</table>
			<div style="color: red">${errors}</div>
		</div>
	</form:form>


</body>
</html>










