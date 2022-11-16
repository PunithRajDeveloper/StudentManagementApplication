<%@page import="antlr.debug.MessageAdapter"%>
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
	String message = (String) request.getAttribute("message");
	%>
	<h3>
		<%
		if (message != null) {
		%>

		<%=message%>
		<%
		}
		%>
	</h3>
	<form action="signup" method="post">

		<table>
			<tr>
				<td><label for="name">Name:</label> <input
					placeholder="Enter your name" name="name" type="text"
					required="required"></td>
			</tr>
			<tr>
				<td><label for="phone">phone:</label> <input
					placeholder="Enter your phone" name="phone" type="tel"
					required="required"></td>
			</tr>
			<tr>
				<td><label for="email">Email:</label> <input
					placeholder="Enter your email" name="email" type="text"
					required="required"></td>
			</tr>
			<tr>
				<td><label for="password">password:</label> <input
					placeholder="Enter your password" name="password" type="password"
					required="required"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>




		</table>





	</form>
</body>
</html>