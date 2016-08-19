<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Exception</title>
</head>
<body>

      <h2><b><font color=red>Product Unavailable</font></b></h2>
      <br><c:out value="${exceptionMsg}"></c:out><br><br>
      <a href="/SpringNewProject/app/Success">ViewProduct</a>

</body>
</html>
