<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>ex2_forward.jsp 페이지 입니다.</h2>
	<%String n = request.getParameter("n"); %>
	<h2>n: <%=n %></h2>
</body>
</html>