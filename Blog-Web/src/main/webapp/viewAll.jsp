<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW ALL</title>
</head>
<body>
<select name="category" id="category">
	<option value="" disabled selected>Choose your Category</option>
	<c:forEach var="c" items="${CATEGORY_VIEW}" varStatus="i">
	<option value="${c.name}">${c.name}</option>
	</c:forEach>
</select>
<table>
	<thead>
		<td>TITLE</td>
		<td>CONTENT</td>
		<td>PUBLISHED_DATE</td>
		<td>MODIFIED_DATE</td>
	</thead>
	<jstl:forEach var="i" items="${VIEW_ALL}" varStatus="invalid">
	<tr>
				<td>${i.name}</td>
				<td>${i.content}</td>
				<td>${i.publishedDate}</td>
				<td>${i.modifiedDate}</td>
	</tr>
	</jstl:forEach>
</table>
${VIEW_ALL_ERROR}
</body>
</html>