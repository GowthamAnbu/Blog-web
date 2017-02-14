<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMMENT</title>
</head>
<body>
<form action="../showList/comment">
	Comment:<input type="text" name="comment">
	<input type="hidden" name="articleId" value=<%=request.getParameter("articleId")%>>
	<input type="submit">
</form>
</body>
</html>