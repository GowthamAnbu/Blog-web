<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REGISTER</title>
</head>
<body>
<form action="/register">
	NAME:<input type="text" name="name" required>
	USER NAME:<input type="text" name="userName" required>
	PASSWORD:<input type="password" name="password" required>
	EMAIL ID:<input type="text" name="emailId" required>
	PHONE NUMBER:<input type="text" name="phoneNumber" required>
	<button type="submit">Register</button>
</form>
${REGISTER_ERROR}
</body>
</html>