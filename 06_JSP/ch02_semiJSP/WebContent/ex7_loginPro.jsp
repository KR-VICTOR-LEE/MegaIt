<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css"></style>
</head>
<body>

<%! String name, id, pw; %>
	<%
		request.setCharacterEncoding("utf-8"); //post방식으로 파라미터 전송시만
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
	%>
	<h1>결과 화면</h1>
	<p>아이디는<%=id %>이고</p>
	<p>비밀번호는<%=pw %>이고</p>
	<p>이름은<%=name %>입니다.</p>
</body>
</html>