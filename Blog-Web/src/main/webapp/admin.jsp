<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN</title>
</head>
<a href="../logout">logout</a>
<body>
<a href="../logout">logout</a>
<table>
		<thead>
		<td>ID</td>
		<td>NAME</td>
		<td>ROLE_ID</td>
		<td>USER_NAME</td>
		<td>EMAIL_ID</td>
		<td>PHONE_NUMBER</td>
	</thead>
<jstl:forEach var="i" items="${VIEW_USERS}" varStatus="invalid">
	<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.role.id}</td>	
				<td>${i.userName}</td>
				<td>${i.emailId}</td>
				<td>${i.phoneNumber}</td>
				<td><a href="../change.jsp?id=${i.id}">Update</a></td>
	</tr>
	</jstl:forEach>
</table>
</body>
</html>