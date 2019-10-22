<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Updating a database using the sql:update tag</title>
<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/dxc" scope="session" user="root"
	password="root" />

</head>
<body>
	<h1>Modify Address List</h1>
	<sql:update dataSource="${dataSource}" var="abc">
    INSERT INTO Student (Roll, Name, Address, Marks) VALUES (?, ?, ?, ?)
    <sql:param value='${param.roll}' />
		<sql:param value='${param.name}' />
		<sql:param value='${param.address}' />
		<sql:param value='${param.marks}' />
	</sql:update>
</body>
</html>