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
<form action="../showList/viewByCategory">
<select name="category" id="category">
	<option value="" disabled selected>Choose your Category</option>
	<jstl:forEach var="i" items="${CATEGORY_VIEW}" varStatus="invalid">
	<option value="${i.name}">${i.name}</option>
	</jstl:forEach>
</select>
<input type="submit">
</form>
<table>
	<thead>
		<td>TITLE</td>
		<td>CONTENT</td>
		<td>PUBLISHED_DATE</td>
		<td>MODIFIED_DATE</td>
		<td>COMMENT</td>
	</thead>
	<jstl:forEach var="i" items="${VIEW_ALL}" varStatus="invalid">
	<tr>
				<td>${i.name}</td>
				<td>${i.content}</td>
				<td>${i.publishedDate}</td>
				<td>${i.modifiedDate}</td>
				<td><a href="../comment.jsp?articleId=${i.id}">addcomment</a></td>
				<td><a href="../showList/viewComments?articleId=${i.id}">viewcomments</a></td>
	</tr>
	</jstl:forEach>
</table>
${VIEW_ALL_ERROR}
</body>
</html>