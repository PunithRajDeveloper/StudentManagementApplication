<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.List"%>
	<%@page import="com.tyss.dto.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Student> list = (List) request.getAttribute("students");
	%>
	<table border="2px">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>
			<th>phone</th>
			<th>password</th>
			<th>view</th>
			<th>Delete</th>
		</tr>
		<%
		for (Student student : list) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getPhone()%></td>
			<td><%=student.getPassword()%></td>
			<td><a href="view?id=<%=student.getId()%>">view</a></td>
			<td><a href="delete?id=<%=student.getId()%>">delete</td>

		</tr>

		<%
		}
		%>

	</table>
</body>
</html>