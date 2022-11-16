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
	String invalid = (String) request.getAttribute("invalid");
	%>
	<%
	if (invalid != null) {
	%>

	<h3 style="color: red">
		<%=invalid%>
	</h3>
	<%
	}
	%>

	<form action="login" method="post">
		Email: <input type="email" placeholder="enter your email id"
			name="email"> Password: <input type="password"
			placeholder="enter your password" name="password"> <input
			type="submit" value="Login">

	</form>
</body>
</html>