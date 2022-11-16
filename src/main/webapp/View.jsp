<%@page import="com.tyss.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Student student = (Student) request.getAttribute("student");
	%>
	<h3>
		Name:<%=student.getName()%></h3>
	<h3>
		Email:<%=student.getEmail()%></h3>
	<h3>
		Password:<%=student.getPassword()%></h3>
</body>
</html>