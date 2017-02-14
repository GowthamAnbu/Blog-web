<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW COMMENTS</title>
</head>
<body>
<jstl:forEach var="i" items="${VIEW_COMMENTS}" varStatus="invalid">
	<tr>
				<td>${i.comment}</td>
	</tr>
	</jstl:forEach>
</body>
</html>