<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE</title>
</head>
<body>
<form action="/showList/update">
	Title:<input type="text" name="title" required/>
	Content:<input type="text" name="content" required>
	<input type="hidden" name="articleId" value="<%=request.getParameter("id")%>">
	<input type="hidden" name="userId" value="<%=request.getParameter("userId")%>">
	<button type="submit">Update</button>
</form>
</body>
</html>