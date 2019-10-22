<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		Username: <input type="text" name="usern" id="usern"><br>
		<input type="submit" value="Go"> <br> Choose Color: <br>
		<input type="checkbox" name="color" value="Red">Red <input
			type="checkbox" name="color" value="Green">Green <input
			type="checkbox" name="color" value="Blue">Blue
	</form>
	<%
		String usern = request.getParameter("usern");
		String[] color = request.getParameterValues("color");

		if (color == null) {
			request.getParameter("<h1>No color Selected</h1>");
		} else {
			for (String c : color) {
				out.println("<h1><font color =" + c + ">Hello, " + usern + "</font></h1>");
			}
		}
	%>
</body>
</html>