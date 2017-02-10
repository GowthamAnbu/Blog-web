<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHOWLIST</title>
</head>
<body>
<a href="showList/viewAll">view all articles</a><br>
<a href="../publish.jsp">Publish Article</a>
<table>
	<thead>
		<td>TITLE</td>
		<td>CONTENT</td>
		<td>PUBLISHED_DATE</td>
		<td>MODIFIED_DATE</td>
	</thead>
	<jstl:forEach var="i" items="${ARTICLE_LIST}" varStatus="invalid">
	<tr>
				<td>${i.name}</td>
				<td>${i.content}</td>
				<td>${i.publishedDate}</td>
				<td>${i.modifiedDate}</td>
				<td><a href="../update.jsp?id=${i.id}&userId=${i.user.id}">Update</a></td>
				<td><a href="../showList/delete?id=${i.id}&userId=${i.user.id}">Delete</a></td>
	</tr>
	</jstl:forEach>
</table>
${SHOW_LIST_ERROR}
</body>
</html>