<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String msg = request.getParameter("msg");
	%>
	<%if("success".equals(msg)){ %>
		<h1>가입이 완료 되었습니다</h1>
	<%}else{%>
		<h1>가입되지 않았습니다.</h1>
		<a href="join.jsp">회원가입하기</a>
	<%}%>
		<hr>
		<button onclick="location.href='<%=conPath%>/lect2_login/login.jsp'">로그인</button>
</body>
</html>