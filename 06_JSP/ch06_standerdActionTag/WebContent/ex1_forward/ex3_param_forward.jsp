<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>ex._param_forward 페이지 입니다.</h1>
	<jsp:forward page="ex4.jsp">
		<jsp:param value="hong" name="id"/>
		<jsp:param value="1111" name="pw"/>
	</jsp:forward>
</body>
</html>