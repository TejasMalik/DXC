<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="number" name="num1" value=""> <input
			type="number" name="num2" value=""> <input type="submit"
			value="Submit">

	</form>

	<%
		int x, y;
		if (request.getParameter("num1") != null || request.getParameter("num2") != null) {
			x = Integer.parseInt(request.getParameter("num1"));
			y = Integer.parseInt(request.getParameter("num2"));
			out.print(x + y);
		}
	%>
	<c:forEach var="j" begin="1" end="10" step="2">
		<h1>
			<c:out value="${j}"></c:out>
		</h1>
	</c:forEach>
</body>
</html>