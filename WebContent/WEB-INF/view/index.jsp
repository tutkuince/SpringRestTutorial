<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Rest DEMO</title>
</head>
<body>
	<h1>SPRING REST DEMO</h1>
	<hr />
	<a href="${pageContext.request.contextPath }/test/hello">Hello</a>
	<br />
	<a href="${pageContext.request.contextPath }/api/students">Get All
		Students</a>
</body>
</html>